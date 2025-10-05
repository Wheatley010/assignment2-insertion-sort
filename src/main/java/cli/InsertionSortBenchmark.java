package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class InsertionSortBenchmark {

    private int[] smallArray;
    private int[] mediumArray;
    private int[] largeArray;
    private InsertionSort sorter;

    @Setup(Level.Invocation)
    public void setup() {
        PerformanceTracker tracker = new PerformanceTracker(); // создаём трекер
        sorter = new InsertionSort(tracker);                    // передаём его в сортировку
        Random rand = new Random();

        smallArray = rand.ints(100, 0, 10000).toArray();
        mediumArray = rand.ints(1000, 0, 10000).toArray();
        largeArray = rand.ints(5000, 0, 10000).toArray();
    }

    @Benchmark
    public void benchmarkSmall() {
        sorter.sort(smallArray.clone());
    }

    @Benchmark
    public void benchmarkMedium() {
        sorter.sort(mediumArray.clone());
    }

    @Benchmark
    public void benchmarkLarge() {
        sorter.sort(largeArray.clone());
    }
}
