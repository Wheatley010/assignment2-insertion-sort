package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    private final PerformanceTracker tracker;

    public InsertionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            tracker.incrementArrayAccesses();

            int j = i - 1;

            // Optimization for nearly-sorted arrays
            if (arr[j] <= key) {
                tracker.incrementComparisons();
                continue;
            }

            while (j >= 0 && arr[j] > key) {
                tracker.incrementComparisons();
                arr[j + 1] = arr[j];
                tracker.incrementArrayAccesses();
                tracker.incrementSwaps();
                j--;
            }

            arr[j + 1] = key;
            tracker.incrementArrayAccesses();
        }
    }
}
