package main.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import main.exception.FileFormatException;
import main.model.Class;
import main.model.Student;

public class Format2StudentReader implements StudentFileReader {

    @Override
    public List<Class> read(String filePath) throws IOException {
        List<Class> classes = new ArrayList<>();
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new FileNotFoundException("Soubor neexistuje: " + filePath);
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            Class currentClass = null;
            int expectedStudentCount = -1;
            int currentStudentCount = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // 1. Pokud není aktuální třída, řádek je název třídy
                if (currentClass == null) {
                    currentClass = new Class(line);
                    continue;
                }

                // 2. Pokud očekávaný počet studentů není nastaven, řádek je jejich počet
                if (expectedStudentCount == -1) {
                    try {
                        expectedStudentCount = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        throw new FileFormatException("Očekáván počet studentů, ale získán: " + line);
                    }
                    continue;
                }

                // 3. Jinak jde o řádek se studentem
                String[] parts = line.split(";");
                if (parts.length != 2) {
                    throw new FileFormatException("Neplatný řádek studenta: " + line);
                }

                currentStudentCount++;
                Student student = new Student(currentStudentCount, parts[0], parts[1]);
                currentClass.addStudent(student);

                // 4. Po načtení všech studentů, přidat třídu do seznamu a resetovat stav
                if (currentStudentCount == expectedStudentCount) {
                    classes.add(currentClass);
                    currentClass = null;
                    expectedStudentCount = -1;
                    currentStudentCount = 0;
                }
            }

            // Ověření na konci
            if (currentClass != null) {
                throw new FileFormatException("Soubor byl předčasně ukončen – nebyli načteni všichni studenti.");
            }
        }

        return classes;
    }
}
