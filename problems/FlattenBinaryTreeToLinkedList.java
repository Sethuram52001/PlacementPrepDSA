/*
Problem:
Given the root of a binary tree, flatten the tree into a "linked list":

* The "linked list" should use the same TreeNode class where the right child pointer points to the 
  next node in the list and the left child pointer is always null.
* The "linked list" should be in the same order as a pre-order traversal of the binary tree.

Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Solution:
We can do a preorder traversal and while doing so we can manipulate the links to left
and right children nodes using a dummy pointer node.

Note: We can't directly call preorder(root.right) since we change the links during recursion, so
we store the current right pointer to the child using another dummy node.
*/

public class FlattenBinaryTreeToLinkedList {
    TreeNode curr;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        preorder(root);
    }

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        if (curr != null) {
            curr.left = null;
            curr.right = root;
        }

        curr = root;
        TreeNode right = root.right;

        preorder(root.left);
        preorder(right);
    }
}