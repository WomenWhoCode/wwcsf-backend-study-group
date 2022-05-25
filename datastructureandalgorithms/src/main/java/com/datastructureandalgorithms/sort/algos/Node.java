package coding.problems;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

// TODO

/**
 * A binary tree where the parent is the minimum of the two children.
 * Given such  a tree find the second minimum value in the tree.
 * A node in the tree will always have 2 or 0 children.
 * Also all leaves will have distinct and unique values.
 *   2
 *  / \
 *  2  4
 * /\  |\
 * 3 2 5 4
 * <p>
 * In this given tree the answer is 3.
 */
class Node {
    Integer value;
    Node left, right;

    Node(Integer value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private static Set<Integer> nodesValues = new HashSet<>();  // 2, 3

    /**
     * This should return the second minimum
     * int value in the given tree
     */
    public static Integer secondMin(Node root) {
        if (root == null || root.left == null || root.right == null) {
            throw new RuntimeException("Tree is empty or has one node. Therefore, cannot find second minimum number.");
        }

        traverse(root);

        List<Integer> sortedList = new ArrayList<>(nodesValues);
        Collections.sort(sortedList);

        return sortedList.get(1);
    }

    private static void traverse(Node root) {
        if (root == null) {
            throw new RuntimeException("Tree is empty.");
        }

        if (root.left != null) {
            traverse(root.left);
        }

        nodesValues.add(root.value);

        if (root.right != null) {
            traverse(root.right);
        }
    }

}
