package main.factory;

import main.reader.Format1StudentReader;
import main.reader.Format2StudentReader;
import main.reader.Format3StudentReader;
import main.reader.StudentFileReader;

/**
 * Factory pro vytváření readerů pro studenty
 */
public class StudentFileReaderFactory {

    /**
     * Enumeration pro formáty souborů se studenty
     */
    public enum StudentFileFormat {
        FORMAT1, FORMAT2, FORMAT3
    }

    /**
     * Vytvoří reader pro zadaný formát
     */
    public static StudentFileReader createReader(StudentFileFormat format) {
        switch (format) {
            case FORMAT1:
                return new Format1StudentReader();
            case FORMAT2:
                return new Format2StudentReader();
            case FORMAT3:
                return new Format3StudentReader();
            default:
                throw new IllegalArgumentException("Nepodporovaný formát souboru: " + format);
        }
    }

    /**
     * Pokusí se detekovat formát souboru podle obsahu
     */
    public static StudentFileFormat detectFormat(String filePath) {
        // Jednoduchá implementace: vždy vrátí FORMAT1
        // V reálné aplikaci by bylo potřeba analyzovat obsah souboru
        return StudentFileFormat.FORMAT1;
    }
}