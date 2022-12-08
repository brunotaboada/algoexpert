package AlgoExSolutions.Medium.FirstDuplicateValue;

// import java.util.*;

/**
 * * First Duplicate Value
 */
class Program {

    public static int firstDuplicateValue(int[] array) {
        // Write your code here.

        for (int idx = 0; idx < array.length; idx++) {
            int targetIdx = Math.abs(array[idx]) - 1;
            if (array[targetIdx] < 0) return Math.abs(array[idx]);

            array[targetIdx] = -array[targetIdx];
        }

        return -1;
    }

    public static void main(String[] args) {
        firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4});
    }

}
