/*
Problem:
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

Link: https://leetcode.com/problems/balanced-binary-tree/

Solution:
We can check the maximum depths reachable from left child and right child for each node.
While doing so, we can validate the condition for balanced binary tree.
*/

public class BalancedBinaryTree {
    boolean isBalanced;

    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        maxDepth(root);
        return isBalanced;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        if (Math.abs(lh - rh) > 1) {
            isBalanced = false;
        }

        return 1 + Math.max(lh, rh);
    }
}