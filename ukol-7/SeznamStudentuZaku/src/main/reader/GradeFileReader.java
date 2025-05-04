package main.reader;

import java.io.IOException;
import java.util.Map;

import main.reader.FileReader;
import main.model.Class;

/**
 * Rozhraní pro čtení známek
 */
public interface GradeFileReader extends FileReader<Map<String, Class>> {
    @Override
    Map<String, Class> read(String filePath) throws IOException;

    /**
     * Načte známky pro zadané třídy
     */
    void loadGradesForClasses(Map<String, Class> classes, String filePath) throws IOException;
}