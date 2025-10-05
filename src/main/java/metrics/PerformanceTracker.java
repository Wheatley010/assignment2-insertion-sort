package metrics;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class to keep track of performance metrics during sorting.
 * It records key operations such as comparisons, swaps, array accesses,
 * and memory allocations.
 */
public class PerformanceTracker {

    private long comparisons;
    private long swaps;
    private long arrayAccesses;
    private long memoryAllocations;

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementArrayAccesses() {
        arrayAccesses++;
    }

    public void incrementMemoryAllocations() {
        memoryAllocations++;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public long getMemoryAllocations() {
        return memoryAllocations;
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
        memoryAllocations = 0;
    }

    /**
     * Saves the collected metrics into a CSV file.
     * If the file doesn't exist, it will be created automatically.
     */
    public void exportToCSV(String filePath, String testName) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // Write header if file is empty or newly created
            writer.write("Test,Comparisons,Swaps,ArrayAccesses,MemoryAllocations\n");
            writer.write(String.format("%s,%d,%d,%d,%d%n",
                    testName, comparisons, swaps, arrayAccesses, memoryAllocations));
            System.out.println("Metrics saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error while writing metrics: " + e.getMessage());
        }
    }
}
