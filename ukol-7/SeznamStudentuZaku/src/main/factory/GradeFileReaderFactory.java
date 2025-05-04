package main.factory;

import main.reader.Format1GradeReader;
import main.reader.Format2GradeReader;
import main.reader.Format3GradeReader;
import main.reader.GradeFileReader;

/**
 * Factory pro vytváření readerů pro známky
 */
public class GradeFileReaderFactory {

    /**
     * Enumeration pro formáty souborů se známkami
     */
    public enum GradeFileFormat {
        FORMAT1, FORMAT2, FORMAT3
    }

    /**
     * Vytvoří reader pro zadaný formát
     */
    public static GradeFileReader createReader(GradeFileFormat format) {
        switch (format) {
            case FORMAT1:
                return new Format1GradeReader();
            case FORMAT2:
                return new Format2GradeReader();
            case FORMAT3:
                return new Format3GradeReader();
            default:
                throw new IllegalArgumentException("Nepodporovaný formát souboru: " + format);
        }
    }

    /**
     * Pokusí se detekovat formát souboru podle obsahu
     */
    public static GradeFileFormat detectFormat(String filePath) {
        // Jednoduchá implementace: vždy vrátí FORMAT1
        // V reálné aplikaci by bylo potřeba analyzovat obsah souboru
        return GradeFileFormat.FORMAT1;
    }
}