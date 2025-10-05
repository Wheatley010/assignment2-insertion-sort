package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private final PerformanceTracker tracker;

    // Конструктор с трекером
    public InsertionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    // Сортировка массива
    public void sort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        long startTime = System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        // Сохраняем время сортировки в трекер
        if (tracker != null) {
            tracker.addRecord(arr.length, durationMs);
        }
    }
}
