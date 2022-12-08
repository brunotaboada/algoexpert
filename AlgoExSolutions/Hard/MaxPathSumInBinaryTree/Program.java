package AlgoExSolutions.Hard.MaxPathSumInBinaryTree;

// import java.util.*;

/**
 * * Max Path Sum In Binary Tree
 */
class Program {
    private static int maxSum;
    public static int maxPathSum(BinaryTree tree) {
        maxSum = Integer.MIN_VALUE;
        maxPathSumHelper(tree);
        return maxSum;
    }

    /**
     * * TC: O(n)
     * * SC: O(log (n))
     */
    private static int maxPathSumHelper(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        int leftPathSum = maxPathSumHelper(tree.left);
        leftPathSum = leftPathSum > 0 ? leftPathSum : 0;
        int rightPathSum = maxPathSumHelper(tree.right);
        rightPathSum = rightPathSum > 0 ? rightPathSum : 0;
        int currentSum = tree.value + leftPathSum + rightPathSum;
        if (currentSum > maxSum) {
          maxSum = currentSum;
        }
        return tree.value + Math.max(leftPathSum, rightPathSum);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
