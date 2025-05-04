package main.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.writer.FileWriter;
import main.model.Class;
import main.model.Student;
import main.model.Subject;

/**
 * Třída pro zápis statistik do souborů
 */
public class StatisticsFileWriter implements FileWriter<List<Class>> {

    @Override
    public void write(List<Class> classes, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = new ArrayList<>();

        lines.add("Statistika prospěchu");
        lines.add("==========================================");

        for (Class clazz : classes) {
            lines.add("\nTřída: " + clazz.getName());
            lines.add("------------------------------------------");

            // Průměr třídy
            lines.add("Průměr třídy: " + String.format("%.2f", clazz.calculateClassAverage()));

            // Průměry podle předmětů
            lines.add("\nPrůměry předmětů:");
            Map<Subject, Double> subjectAverages = clazz.calculateSubjectAverages();
            for (Subject subject : Subject.values()) {
                Double average = subjectAverages.get(subject);
                if (average != null) {
                    lines.add(subject.getName() + ": " + String.format("%.2f", average));
                }
            }

            // Průměry studentů
            lines.add("\nPrůměry studentů:");
            for (Student student : clazz.getStudents()) {
                lines.add(student.getFirstName() + " " + student.getLastName() +
                        ": " + String.format("%.2f", student.calculateAverage()));
            }

            lines.add("\n");
        }

        Files.write(path, lines);
    }
}