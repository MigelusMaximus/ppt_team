package main.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import main.builder.ClassBuilder;
import main.builder.StudentBuilder;
import main.exception.FileFormatException;
import main.reader.StudentFileReader;
import main.model.Class;
import main.model.Student;

/**
 * Implementace čtení souboru studentů ve formátu 1:
 *
 * 7A
 * Jmeno1;Prijmeni1
 * Jmeno2;Prijmeni2
 * ...
 */
public class Format1StudentReader implements StudentFileReader {

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
            ClassBuilder classBuilder = new ClassBuilder();

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Pokud řádek neobsahuje středník, předpokládáme že je to název třídy
                if (!line.contains(";")) {
                    if (currentClass != null) {
                        classes.add(currentClass);
                    }
                    currentClass = classBuilder.setName(line).build();
                } else {
                    // Jinak je to student ve formátu Jmeno;Prijmeni
                    if (currentClass == null) {
                        throw new FileFormatException("Neplatný formát souboru: chybí název třídy před jménem studenta");
                    }

                    String[] parts = line.split(";");
                    if (parts.length != 2) {
                        throw new FileFormatException("Neplatný formát řádku studenta: " + line);
                    }

                    Student student = new StudentBuilder()
                            .setFirstName(parts[0])
                            .setLastName(parts[1])
                            .build();

                    currentClass.addStudent(student);
                }
            }

            // Přidání poslední třídy
            if (currentClass != null) {
                classes.add(currentClass);
            }
        }

        if (classes.isEmpty()) {
            throw new FileFormatException("Soubor neobsahuje žádné třídy");
        }

        return classes;
    }
}