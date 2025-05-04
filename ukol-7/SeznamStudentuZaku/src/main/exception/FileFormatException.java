package main.exception;

/**
 * Výjimka při neplatném formátu souboru
 */
public class FileFormatException extends RuntimeException {
    public FileFormatException(String message) {
        super(message);
    }

    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}