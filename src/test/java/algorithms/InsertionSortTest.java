package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    private final PerformanceTracker tracker = new PerformanceTracker();
    private final InsertionSort sorter = new InsertionSort(tracker);

    @Test
    void testRegularArray() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        sorter.sort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseOrder() {
        int[] arr = {9, 7, 5, 3, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {4, 2, 4, 2, 4};
        sorter.sort(arr);
        assertArrayEquals(new int[]{2, 2, 4, 4, 4}, arr);
    }

    @Test
    void testArrayWithNegativeNumbers() {
        int[] arr = {3, -1, 0, -5, 2};
        sorter.sort(arr);
        assertArrayEquals(new int[]{-5, -1, 0, 2, 3}, arr);
    }
}
