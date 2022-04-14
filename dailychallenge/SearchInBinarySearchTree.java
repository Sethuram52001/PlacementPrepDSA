/*
Problem:
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree 
rooted with that node. If such a node does not exist, return null.

Link: https://leetcode.com/problems/search-in-a-binary-search-tree/

Solution:
Use the binary search tree property:
left sub-tree values < root
root > right sub-tree values
*/

public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val) {
                return curr;
            } else if (curr.val < val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return null;
    }
}