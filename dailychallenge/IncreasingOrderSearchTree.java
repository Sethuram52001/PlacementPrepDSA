/*
Problem:
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, 
and every node has no left child and only one right child.

Link: https://leetcode.com/problems/increasing-order-search-tree/

Solution:
We can perform the same in-order traversal. During the traversal, we'll construct the answer on the fly, reusing the nodes 
of the given tree by cutting their left child and adjoining them to the answer.
*/

public class IncreasingOrderSearchTree {
    TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyRoot = new TreeNode(-1);
        curr = dummyRoot;
        inorder(root);
        return dummyRoot.right;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        root.left = null;
        curr.right = root;
        curr = root;
        inorder(root.right);
    }
}