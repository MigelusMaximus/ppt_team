package test;

import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        String[] filesToTest = {
                "src/main/data/studenti_format3.csv",
                "src/main/data/znamky_format3.csv"
        };

        for (String file : filesToTest) {
            System.out.println("Testuji soubor: " + file);
            try {
                List<String> lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
                for (String line : lines) {
                    System.out.println("[" + line + "]");
                }
                System.out.println("Soubor OK: " + file);
            } catch (Exception e) {
                System.err.println("Chyba při načítání: " + file);
                e.printStackTrace();
            }
        }
    }
}
