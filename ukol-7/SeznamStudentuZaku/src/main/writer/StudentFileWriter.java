package main.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import main.writer.FileWriter;
import main.model.Class;
import main.model.Student;

/**
 * Třída pro zápis studentů do souborů
 */
public class StudentFileWriter implements FileWriter<Class> {

    @Override
    public void write(Class clazz, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = new ArrayList<>();

        // Přidáme název třídy
        lines.add(clazz.getName());

        // Přidáme počet studentů
        lines.add(String.valueOf(clazz.getStudentCount()));

        // Přidáme studenty
        for (Student student : clazz.getStudents()) {
            lines.add(student.toString());
        }

        Files.write(path, lines);
    }
}