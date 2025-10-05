# Assignment 2: Insertion Sort

## Description
This project implements Insertion Sort with performance tracking and benchmarking.

## Structure
- `algorithms/InsertionSort.java` — insertion sort implementation.
- `metrics/PerformanceTracker.java` — performance counters and CSV export.
- `cli/BenchmarkRunner.java` — command-line benchmarking tool.
- `src/test/java/algorithms/InsertionSortTest.java` — unit tests.

## How to Run
1. Build the project with Maven: `mvn clean install`
2. Run benchmarks: `mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"`

## Complexity Analysis
- Best case: O(n) — array already sorted
- Worst case: O(n²) — array sorted in reverse
- Average case: O(n²)
