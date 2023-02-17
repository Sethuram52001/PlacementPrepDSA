/*
Problem:
Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two 
different nodes in the tree.

Link: https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

Solution:
Inorder traversal
*/

public class MinimumDistanceBetweenBSTNodes {
    Integer minDiff = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }

        return minDiff;
    }
}
