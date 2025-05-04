package main.provider;

import java.io.IOException;
import java.util.Map;

import main.factory.GradeFileReaderFactory;
import main.factory.GradeFileReaderFactory.GradeFileFormat;
import main.model.Class;
import main.reader.GradeFileReader;

/**
 * Provider pro práci se známkami
 */
public class GradeProvider {
    private final GradeFileReaderFactory.GradeFileFormat format;
    private final GradeFileReader reader;

    public GradeProvider(GradeFileFormat format) {
        this.format = format;
        this.reader = GradeFileReaderFactory.createReader(format);
    }

    public void loadGrades(Map<String, Class> classes, String filePath) throws IOException {
        reader.loadGradesForClasses(classes, filePath);
    }
}