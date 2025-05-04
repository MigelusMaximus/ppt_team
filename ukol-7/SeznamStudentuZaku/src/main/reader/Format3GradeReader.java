package main.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.exception.FileFormatException;
import main.model.Class;
import main.model.Student;
import main.model.Subject;

public class Format3GradeReader implements GradeFileReader {

    @Override
    public Map<String, Class> read(String filePath) throws IOException {
        // Not used in your workflow
        return new HashMap<>();
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
            int studentIndex = 0;
            int gradeCounter = 0;
            int expectedStudentCount = 0;
            Subject[] subjects = Subject.values();
            boolean readingClassHeader = true;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                // Class header section
                if (readingClassHeader) {
                    currentClass = classes.get(line);
                    if (currentClass == null) {
                        throw new FileFormatException("Třída '" + line + "' nebyla nalezena");
                    }
                    readingClassHeader = false;
                    continue;
                }

                // Student count line
                if (gradeCounter == 0) {
                    try {
                        expectedStudentCount = Integer.parseInt(line);
                        if (expectedStudentCount != currentClass.getStudentCount()) {
                            throw new FileFormatException("Nesouhlasí počet studentů pro třídu " +
                                    currentClass.getName());
                        }
                        gradeCounter++;
                        continue;
                    } catch (NumberFormatException e) {
                        throw new FileFormatException("Očekáván počet studentů, ale získán: " + line);
                    }
                }

                // Grade lines
                try {
                    int grade = Integer.parseInt(line);
                    if (grade < 1 || grade > 5) {
                        throw new FileFormatException("Neplatná známka: " + grade);
                    }

                    List<Student> students = currentClass.getStudents();
                    if (studentIndex >= students.size()) {
                        throw new FileFormatException("Překročen počet studentů v třídě " +
                                currentClass.getName());
                    }

                    // Assign grade to current subject
                    Subject currentSubject = subjects[(gradeCounter - 1) % subjects.length];
                    students.get(studentIndex).addGrade(currentSubject, grade);
                    gradeCounter++;

                    // Move to next student after all subjects
                    if ((gradeCounter - 1) % subjects.length == 0) {
                        studentIndex++;
                        if (studentIndex == expectedStudentCount) {
                            // Reset for next class
                            readingClassHeader = true;
                            studentIndex = 0;
                            gradeCounter = 0;
                        }
                    }
                } catch (NumberFormatException e) {
                    // If not a number, it should be a new class name
                    if (line.length() <= 5) {  // Assuming class names are short
                        currentClass = classes.get(line);
                        if (currentClass == null) {
                            throw new FileFormatException("Třída '" + line + "' nebyla nalezena");
                        }
                        readingClassHeader = false;
                        studentIndex = 0;
                        gradeCounter = 0;
                    } else {
                        throw new FileFormatException("Neplatný formát známky: " + line);
                    }
                }
            }
        }
    }
}