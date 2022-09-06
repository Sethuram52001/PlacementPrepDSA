/*
Problem: 
Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing 
a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node. 

Link: https://leetcode.com/problems/binary-tree-pruning/

Solution:
Recursive solution:
A subtree will be pruned if root's val = 0 and it doesn't have any child,
now this will be updated to the top level and so on.
*/

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }

        return root;
    }
}
