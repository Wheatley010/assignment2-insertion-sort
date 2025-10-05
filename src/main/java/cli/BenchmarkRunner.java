package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;

import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000};
        Random random = new Random();
        PerformanceTracker tracker = new PerformanceTracker();

        InsertionSort sorter = new InsertionSort(tracker); // передаём tracker в конструктор

        System.out.printf("%-10s %-15s%n", "Size", "Time (ms)");
        System.out.println("-------------------------");

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(10000);
            }

            long startTime = System.nanoTime();
            sorter.sort(arr);
            long endTime = System.nanoTime();

            double durationMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-10d %-15.3f%n", size, durationMs);

            tracker.addRecord(size, durationMs);
        }

        tracker.exportToCSV("docs/performance-plots/benchmark_results.csv");
    }
}
