package main.reader;

import main.builder.ClassBuilder;
import main.builder.StudentBuilder;
import main.exception.FileFormatException;
import main.model.Class;
import main.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Format3StudentReader implements StudentFileReader {

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
            int expectedCount = -1;
            int loadedCount = 0;
            String firstName = null;
            boolean expectingClassName = true;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // First line should be class name
                if (expectingClassName) {
                    currentClass = new ClassBuilder().setName(line).build();
                    expectingClassName = false;
                    continue;
                }

                // Second line should be student count
                if (expectedCount == -1) {
                    try {
                        expectedCount = Integer.parseInt(line);
                        continue;
                    } catch (NumberFormatException e) {
                        throw new FileFormatException("Očekáván počet studentů, ale získán: " + line);
                    }
                }

                // Process student names
                if (firstName == null) {
                    firstName = line;
                } else {
                    if (currentClass == null) {
                        throw new FileFormatException("Student bez předchozí definice třídy: " + firstName + " " + line);
                    }

                    Student student = new StudentBuilder()
                            .setFirstName(firstName)
                            .setLastName(line)
                            .build();

                    currentClass.addStudent(student);
                    loadedCount++;
                    firstName = null;

                    // Check if we've loaded all expected students
                    if (loadedCount == expectedCount) {
                        classes.add(currentClass);
                        expectingClassName = true;
                        expectedCount = -1;
                        loadedCount = 0;
                    }
                }
            }

            // Add the last class if it wasn't added
            if (currentClass != null && !classes.contains(currentClass)) {
                if (loadedCount != expectedCount) {
                    throw new FileFormatException("Nesouhlasí počet studentů: očekáváno " + expectedCount + ", načteno " + loadedCount);
                }
                classes.add(currentClass);
            }

            if (classes.isEmpty()) {
                throw new FileFormatException("Soubor neobsahuje žádné třídy.");
            }

            return classes;
        }
    }
}