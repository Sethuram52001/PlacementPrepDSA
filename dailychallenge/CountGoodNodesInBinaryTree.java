/*
Problem:
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
Return the number of good nodes in the binary tree.  

Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/

Solution:
WE can use DFS to traverse the tree, while doing so we can record the maximum value along the path from the root to the node.
*/

public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int noOfGoodNodes = root.val >= max ? 1 : 0;
        noOfGoodNodes += goodNodes(root.left, Math.max(root.val, max));
        noOfGoodNodes += goodNodes(root.right, Math.max(root.val, max));

        return noOfGoodNodes;
    }
}