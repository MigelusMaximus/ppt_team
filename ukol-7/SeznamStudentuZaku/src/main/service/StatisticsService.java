package main.service;

import java.io.IOException;
import java.util.List;

import main.model.Class;
import main.writer.StatisticsFileWriter;

/**
 * Služba pro výpočet a export statistik
 */
public class StatisticsService {
    private final StatisticsFileWriter writer;

    public StatisticsService() {
        this.writer = new StatisticsFileWriter();
    }

    public void exportStatistics(List<Class> classes, String filePath) throws IOException {
        writer.write(classes, filePath);
    }
}