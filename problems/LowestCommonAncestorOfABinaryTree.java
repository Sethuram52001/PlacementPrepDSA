/*
Problem:
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as 
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

Solution: 
DFS using recursion
*/

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        else if (right == null) {
            return left;
        }

        else {
            return root;
        }
    }
}