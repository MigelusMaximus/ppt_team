package main.reader;

import java.io.IOException;
import java.util.List;

import main.reader.FileReader;
import main.model.Class;

/**
 * Rozhraní pro čtení seznamu tříd a studentů
 */
public interface StudentFileReader extends FileReader<List<Class>> {
    @Override
    List<Class> read(String filePath) throws IOException;
}