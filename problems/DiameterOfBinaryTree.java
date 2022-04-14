/*
Problem:
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Link: https://leetcode.com/problems/diameter-of-binary-tree/

Solution:
Prerequisites:
1. Diameter - length of a path between two nodes
2. It isn't necessary it must pass through the root

So, the idea is to find the maximum sum of left height and right height of each node.
Here, left height and right height mean the maximum depth reachable from the nodes.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class DiameterOfBinaryTree {
    int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        diameterOfBT(root);
        return maxDiameter;
    }

    private int diameterOfBT(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = diameterOfBT(root.left);
        int rh = diameterOfBT(root.right);
        maxDiameter = Math.max(maxDiameter, lh + rh);
        return 1 + Math.max(lh, rh);
    }
}