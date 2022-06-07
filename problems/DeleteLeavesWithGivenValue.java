/*
Problem:
Given a binary tree root and an integer target, delete all the leaf nodes with value target.

Note that once you delete a leaf node with value target, if its parent node becomes a leaf node 
and has the value target, it should also be deleted (you need to continue doing that until you cannot).

Link: https://leetcode.com/problems/delete-leaves-with-a-given-value/

Solution:
We can construct a recursive traversal of the given tree, while doing so we can
check for the condition that whether a given node is a leaf node and its value is
equal to target, if so we return null(because we need to update the tree). 
*/

public class DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }

        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        TreeNode left = removeLeafNodes(root.left, target);
        TreeNode right = removeLeafNodes(root.right, target);

        if (left == null && right == null && target == root.val) {
            return null;
        }

        root.left = left;
        root.right = right;

        return root;
    }
}