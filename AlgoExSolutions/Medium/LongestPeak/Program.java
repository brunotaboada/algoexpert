package AlgoExSolutions.Medium.LongestPeak;

// import java.util.*;

/**
 * * Longest Peak
 */
class Program {
    public static int longestPeak(int[] array) {
        // Write your code here.
        int peakLength = 0, i = 1;
        boolean isPeak = false;

        while (i < array.length - 1) {
            isPeak = array[i - 1] < array[i] && array[i] > array[i + 1];

            if (!isPeak) {
                ++i;
                continue;
            }

            int leftIdx = i - 2;
            while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) --leftIdx;

            int rightIdx = i + 2;
            while (rightIdx < array.length && array[rightIdx - 1] > array[rightIdx]) ++rightIdx;

            peakLength = Math.max(peakLength, rightIdx - leftIdx - 1);

            i = rightIdx;
        }

        return peakLength;
    }

    public static void main(String[] args) {
        longestPeak(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3});
    }

}
