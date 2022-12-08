package AlgoExSolutions.Hard.LargestRange;

import java.util.HashMap;
import java.util.Map;

/**
 * * Largest Range
 */
class Program {
    public static int[] largestRange(int[] array) {
        // Write your code here.
        Map<Integer, Boolean> visited = new HashMap<>();

        for (int num : array) visited.put(num, false);

        int start = 0, end = 0, maxLen = Integer.MIN_VALUE;

        for (int num : array) {
            if (visited.get(num)) continue;

            int currentStart = num - 1;
            while (visited.containsKey(currentStart)) {
                visited.put(currentStart, true);
                currentStart--;
            }

            int currentEnd = num + 1;
            while (visited.containsKey(currentEnd)) {
                visited.put(currentEnd, true);
                currentEnd++;
            }

            currentStart++;
            currentEnd--;

            int currRangeLength = currentEnd - currentStart + 1;
            if (maxLen < currRangeLength) {
                maxLen = currRangeLength;
                start = currentStart;
                end = currentEnd;
            }
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});
    }
}
