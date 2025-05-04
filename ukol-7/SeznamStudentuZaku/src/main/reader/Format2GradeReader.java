package main.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import main.exception.FileFormatException;
import main.exception.StudentNotFoundException;
import main.model.Class;
import main.model.Student;
import main.model.Subject;

public class Format2GradeReader implements GradeFileReader {

    @Override
    public Map<String, Class> read(String filePath) throws IOException {
        throw new UnsupportedOperationException("Použijte metodu loadGradesForClasses");
    }

    @Override
    public void loadGradesForClasses(Map<String, Class> classes, String filePath) throws IOException {
        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new FileNotFoundException("Soubor neexistuje: " + filePath);
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            Class currentClass = null;
            int expectedStudentCount = -1;
            int currentStudentIndex = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // Pokud nemáme aktuální třídu, pokusíme se ji najít podle názvu
                if (currentClass == null) {
                    currentClass = classes.get(line);
                    if (currentClass == null) {
                        throw new FileFormatException("Třída '" + line + "' nebyla nalezena v načtených třídách.");
                    }
                    continue;
                }

                // Pokud ještě nemáme počet studentů, další řádek je jejich počet
                if (expectedStudentCount == -1) {
                    try {
                        expectedStudentCount = Integer.parseInt(line);
                        // kontrola správnosti počtu studentů
                        if (expectedStudentCount != currentClass.getStudentCount()) {
                            throw new FileFormatException("Nesouhlasí počet studentů pro třídu " + currentClass.getName() +
                                    ": očekáváno " + expectedStudentCount + ", načteno " + currentClass.getStudentCount());
                        }
                    } catch (NumberFormatException e) {
                        throw new FileFormatException("Očekáván počet studentů, ale nalezeno: " + line);
                    }
                    currentStudentIndex = 0;
                    continue;
                }

                // Řádek se známkami ve formátu "1;2;3;4;5"
                List<Student> students = currentClass.getStudents();
                if (currentStudentIndex >= students.size()) {
                    throw new StudentNotFoundException("Pro třídu " + currentClass.getName() +
                            " je více sad známek než studentů.");
                }

                Student student = students.get(currentStudentIndex);
                String[] grades = line.split(";");
                Subject[] subjects = Subject.values();

                if (grades.length != subjects.length) {
                    throw new FileFormatException("Počet známek nesouhlasí s počtem předmětů u studenta " + student.getFullName());
                }

                for (int i = 0; i < grades.length; i++) {
                    try {
                        int grade = Integer.parseInt(grades[i]);
                        if (grade < 1 || grade > 5) {
                            throw new FileFormatException("Neplatná známka: " + grade);
                        }
                        student.addGrade(subjects[i], grade);
                    } catch (NumberFormatException e) {
                        throw new FileFormatException("Neplatná známka: " + grades[i]);
                    }
                }

                currentStudentIndex++;

                // pokud jsme dočetli všechny známky studentů, resetuj
                if (currentStudentIndex == expectedStudentCount) {
                    currentClass = null;
                    expectedStudentCount = -1;
                }
            }

            // Kontrola, jestli poslední třída nebyla přerušena
            if (currentClass != null && currentStudentIndex != expectedStudentCount) {
                throw new FileFormatException("Neúplná sada známek pro třídu " + currentClass.getName());
            }
        }
    }
}
