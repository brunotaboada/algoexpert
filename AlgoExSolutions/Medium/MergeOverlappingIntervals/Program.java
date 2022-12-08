package AlgoExSolutions.Medium.MergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * * Merge Overlapping Intervals
 */
class Program {

    /**
     * * TC: O(n log(n))
     * * SC: O(n)
     */
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        // Write your code here.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] previous = intervals[0];
        mergedIntervals.add(previous);

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] <= previous[1]) previous[1] = Math.max(current[1], previous[1]);
            else {
                previous = current;
                mergedIntervals.add(previous);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        mergeOverlappingIntervals(new int[][]{
            {1, 2},
            {3, 5},
            {4, 7},
            {6, 8},
            {9, 10}
        });
    }
}
