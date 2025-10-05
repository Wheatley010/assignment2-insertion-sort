package metrics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PerformanceTracker {

    private final List<Record> records = new ArrayList<>();

    public void addRecord(int size, double timeMs) {
        records.add(new Record(size, timeMs));
    }

    public void exportToCSV(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Size,Time(ms)\n");
            for (Record r : records) {
                writer.write(r.size + "," + r.timeMs + "\n");
            }
            System.out.println("Results exported to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static class Record {
        int size;
        double timeMs;

        Record(int size, double timeMs) {
            this.size = size;
            this.timeMs = timeMs;
        }
    }
}
