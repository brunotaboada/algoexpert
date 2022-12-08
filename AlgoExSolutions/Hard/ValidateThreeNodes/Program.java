package AlgoExSolutions.Hard.ValidateThreeNodes;

// import java.util.*;

/**
 * * Validate Three Nodes
 */
class Program {
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        boolean oneIsAncestor = goDownTheTree(nodeOne, nodeTwo);
        boolean oneIsDescendant = goDownTheTree(nodeTwo, nodeOne);
        boolean threeIsAncestor = goDownTheTree(nodeThree, nodeTwo);
        boolean threeIsDescendant = goDownTheTree(nodeTwo, nodeThree);
        return isAncestorAndDescendantOrNot(oneIsAncestor, oneIsDescendant, threeIsAncestor,threeIsDescendant);
    }

    private boolean goDownTheTree(BST node, BST nodeToFind) {
        while (node != null) {
            if (node == nodeToFind) return true;
            if (nodeToFind.value < node.value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    private boolean isAncestorAndDescendantOrNot(
        boolean oneIsAncestor,
        boolean oneIsDescendant,
        boolean threeIsAncestor,
        boolean threeIsDescendant
        ) {
        if (oneIsAncestor == true && threeIsDescendant == true) {
            return true;
        } else if (oneIsDescendant == true && threeIsAncestor == true) {
            return true;
        } else {
            return false;
        }
    }


}
