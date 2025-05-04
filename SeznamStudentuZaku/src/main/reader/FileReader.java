package main.reader;

import java.io.IOException;

/**
 * Obecné rozhraní pro čtení souborů
 */
public interface FileReader<T> {
    T read(String filePath) throws IOException;
}