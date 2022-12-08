package AlgoExSolutions.Hard.SameBSTs;

import java.util.ArrayList;
import java.util.List;

/**
 * * Same BSTs
 */
class Program {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() == 0 && arrayTwo.size() == 0) {
            return true;
        }
        if ((arrayOne.size() != arrayTwo.size()) || (arrayOne.get(0) != arrayTwo.get(0))) {
            return false;
        }
        if (arrayOne.size() <= 1) {
            return arrayOne.get(0) == arrayTwo.get(0);
        }
        List<Integer> leftTree1 = new ArrayList<>();
        List<Integer> rightTree1 = new ArrayList<>();
        List<Integer> leftTree2 = new ArrayList<>();
        List<Integer> rightTree2 = new ArrayList<>();
        for (int i = 1; i < arrayOne.size(); i++) {
            if (arrayOne.get(i) < arrayOne.get(0)) {
                leftTree1.add(arrayOne.get(i));
            } else {
                rightTree1.add(arrayOne.get(i));
            }
            if (arrayTwo.get(i) < arrayTwo.get(0)) {
                leftTree2.add(arrayTwo.get(i));
            } else {
                rightTree2.add(arrayTwo.get(i));
            }
        }
        return sameBsts(leftTree1, leftTree2) && sameBsts(rightTree1, rightTree2);
    }
}

