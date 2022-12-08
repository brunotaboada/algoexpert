package AlgoExSolutions.Hard.SubarraySort;

// import java.util.*;

/**
 * * Sub-array Sort
 */
class Program {
    private static boolean isIndexUnsorted(int index, int[] array) {
        if (index == 0) return array[index] > array[index + 1];

        if (index == array.length - 1) return array[index] < array[index - 1];

        return array[index] < array[index - 1] || array[index] > array[index + 1];
    }

    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int len = array.length;
        int maxUnsorted = Integer.MIN_VALUE, minUnsorted = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            if (!isIndexUnsorted(i, array)) continue;

            minUnsorted = Math.min(minUnsorted, array[i]);
            maxUnsorted = Math.max(maxUnsorted, array[i]);
        }

        if (minUnsorted == Integer.MAX_VALUE) return new int[]{-1, -1};

        int firstIdx = 0;
        while (array[firstIdx] <= minUnsorted) ++firstIdx;

        int secondIdx = array.length - 1;
        while (array[secondIdx] >= maxUnsorted) --secondIdx;

        return new int[]{firstIdx, secondIdx};
    }

    public static void main(String[] args) {
        subarraySort(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});
    }

}
