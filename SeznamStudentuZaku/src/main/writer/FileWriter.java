package main.writer;

import java.io.IOException;

/**
 * Obecné rozhraní pro zápis do souborů
 */
public interface FileWriter<T> {
    void write(T data, String filePath) throws IOException;
}