package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import main.exception.FileFormatException;
import main.exception.StudentNotFoundException;
import main.factory.GradeFileReaderFactory.GradeFileFormat;
import main.factory.StudentFileReaderFactory.StudentFileFormat;
import main.model.Class;
import main.provider.GradeProvider;
import main.provider.StudentProvider;
import main.service.StatisticsService;

/**
 * Hlavní třída aplikace
 */
public class Main {

    public static void main(String[] args) {
        // Kontrola argumentů
        if (args.length < 3) {
            System.out.println("Použití: java Main <soubor_studentu> <soubor_znamek> <vystupni_adresar>");
            return;
        }

        String studentFile = args[0];
        String gradesFile = args[1];
        String outputDir = args[2];

        // Kontrola existence výstupního adresáře
        if (!Files.exists(Paths.get(outputDir))) {
            try {
                Files.createDirectories(Paths.get(outputDir));
            } catch (IOException e) {
                System.err.println("Nepodařilo se vytvořit výstupní adresář: " + e.getMessage());
                return;
            }
        }

        try {
            // Načtení studentů
            StudentProvider studentProvider = new StudentProvider(StudentFileFormat.FORMAT1);
            studentProvider.loadStudents(studentFile);
            List<Class> classes = studentProvider.getClasses();
            Map<String, Class> classesMap = studentProvider.getClassesMap();

            System.out.println("Načteno " + classes.size() + " tříd");
            for (Class clazz : classes) {
                System.out.println("Třída " + clazz.getName() + ": " + clazz.getStudentCount() + " studentů");
            }

            // Načtení známek
            GradeProvider gradeProvider = new GradeProvider(GradeFileFormat.FORMAT1);
            gradeProvider.loadGrades(classesMap, gradesFile);

            System.out.println("Známky načteny");

            // Export tříd do souborů
            studentProvider.exportAllClasses(outputDir);
            System.out.println("Seznamy tříd exportovány do adresáře: " + outputDir);

            // Export statistik
            StatisticsService statisticsService = new StatisticsService();
            statisticsService.exportStatistics(classes, outputDir + "/statistiky.txt");
            System.out.println("Statistiky exportovány do: " + outputDir + "/statistiky.txt");

        } catch (FileFormatException e) {
            System.err.println("Chyba formátu souboru: " + e.getMessage());
        } catch (StudentNotFoundException e) {
            System.err.println("Student nebyl nalezen: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Chyba I/O: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Neočekávaná chyba: " + e.getMessage());
            e.printStackTrace();
        }
    }
}