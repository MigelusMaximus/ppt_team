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
import main.exception.StudentNotFoundException;
import main.reader.GradeFileReader;
import main.model.Class;
import main.model.Student;
import main.model.Subject;

/**
 * Implementace čtení známek ve formátu 1:
 *
 * 7A
 * 1;1;3;4;1
 * 2;4;3;4;1
 * ...
 */
public class Format1GradeReader implements GradeFileReader {

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
            int studentIndex = 0;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Řádek bez středníků je název třídy
                if (!line.contains(";")) {
                    currentClass = classes.get(line);
                    if (currentClass == null) {
                        throw new FileFormatException("Třída '" + line + "' nebyla nalezena v načtených třídách");
                    }
                    studentIndex = 0;
                } else {
                    // Řádek se známkami
                    if (currentClass == null) {
                        throw new FileFormatException("Neplatný formát souboru: chybí název třídy před známkami");
                    }

                    List<Student> students = currentClass.getStudents();
                    if (studentIndex >= students.size()) {
                        throw new StudentNotFoundException("Pro třídu " + currentClass.getName() +
                                " je více sad známek než studentů");
                    }

                    Student student = students.get(studentIndex);
                    String[] gradesStr = line.split(";");

                    // Kontrola, zda je správný počet známek (5 předmětů)
                    if (gradesStr.length != 5) {
                        throw new FileFormatException("Nesprávný počet známek pro studenta " +
                                student.getFirstName() + " " + student.getLastName() +
                                ": očekáváno 5, načteno " + gradesStr.length);
                    }

                    // Načtení známek podle pevného pořadí (MAT, FYZ, IT, TV, CJ)
                    Subject[] subjects = Subject.values();
                    for (int i = 0; i < gradesStr.length; i++) {
                        try {
                            int grade = Integer.parseInt(gradesStr[i]);
                            if (grade < 1 || grade > 5) {
                                throw new FileFormatException("Neplatná známka: " + grade);
                            }
                            // Předávání objektu Subject přímo do metody addGrade
                            student.addGrade(subjects[i], grade);
                        } catch (NumberFormatException e) {
                            throw new FileFormatException("Neplatná známka: " + gradesStr[i]);
                        }
                    }

                    studentIndex++;
                }
            }
        }
    }
}