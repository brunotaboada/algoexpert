package AlgoExSolutions.Medium.MonotonicArray;

// import java.util.*;

/**
 * * Monotonic Array
 */
class Program {
    public static boolean isMonotonic(int[] array) {
        // Write your code here.
        if (array == null || array.length <= 2) return true;

        boolean isIncreasing = true, isDecreasing = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) isIncreasing = false;
            else if (array[i] < array[i + 1]) isDecreasing = false;
        }

        return isIncreasing || isDecreasing;
    }

    public static void main(String[] args) {
        isMonotonic(new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001});
    }

}
