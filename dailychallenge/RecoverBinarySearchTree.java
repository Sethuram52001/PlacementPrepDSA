/*
Problem:
You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were 
swapped by mistake. Recover the tree without changing its structure.

Link: https://leetcode.com/problems/recover-binary-search-tree/

Solution:
We can do a inorder traversal and check for the adjacent values which don't appear to
be in place.
*/

public class RecoverBinarySearchTree {
    TreeNode prev, firstSwap, secondSwap;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        prev = null;
        firstSwap = null;
        secondSwap = null;

        inorder(root);
        int temp = firstSwap.val;
        firstSwap.val = secondSwap.val;
        secondSwap.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (firstSwap == null) {
                firstSwap = prev;
            }
            secondSwap = root;
        }
        prev = root;
        inorder(root.right);
    }
}