package AlgoExSolutions.Medium.MoveElementToEnd;

import java.util.List;

/**
 * * Move Element To End
 */
class Program {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int lastIdx = array.size() - 1, firstIdx = 0;

        while (firstIdx < lastIdx) {
            while (lastIdx > firstIdx && array.get(lastIdx) == toMove) --lastIdx;

            if (array.get(firstIdx) == toMove) {
                array.set(firstIdx, array.get(lastIdx));
                array.set(lastIdx, toMove);
                --lastIdx;
            }

            ++firstIdx;
        }

        return array;
    }

    public static void main(String[] args) {
        moveElementToEnd(
            List.of(2, 1, 2, 2, 2, 3, 4, 2),
            2
        );
    }

}
