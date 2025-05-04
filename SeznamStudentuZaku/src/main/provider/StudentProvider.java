package main.provider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.factory.StudentFileReaderFactory;
import main.factory.StudentFileReaderFactory.StudentFileFormat;
import main.model.Class;
import main.reader.StudentFileReader;
import main.writer.StudentFileWriter;

/**
 * Provider pro práci se seznamy studentů
 */
public class StudentProvider {
    private final StudentFileReaderFactory.StudentFileFormat format;
    private final StudentFileReader reader;
    private final StudentFileWriter writer;
    private List<Class> classes;

    public StudentProvider(StudentFileFormat format) {
        this.format = format;
        this.reader = StudentFileReaderFactory.createReader(format);
        this.writer = new StudentFileWriter();
    }

    public void loadStudents(String filePath) throws IOException {
        classes = reader.read(filePath);
    }

    public List<Class> getClasses() {
        return classes;
    }

    public Map<String, Class> getClassesMap() {
        Map<String, Class> classesMap = new HashMap<>();
        for (Class clazz : classes) {
            classesMap.put(clazz.getName(), clazz);
        }
        return classesMap;
    }

    public void exportClassToFile(Class clazz, String outputDir) throws IOException {
        String filePath = outputDir + "/" + clazz.getName() + ".csv";
        writer.write(clazz, filePath);
    }

    public void exportAllClasses(String outputDir) throws IOException {
        for (Class clazz : classes) {
            exportClassToFile(clazz, outputDir);
        }
    }
}