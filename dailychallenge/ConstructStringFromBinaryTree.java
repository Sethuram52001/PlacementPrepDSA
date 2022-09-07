/*
Problem:
Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree 
with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string 
and the original binary tree.

Link: https://leetcode.com/problems/construct-string-from-binary-tree/

Solution:
While doing a preorder traversal, append parenthesis during a recursive call. Special case is when the left child of node
is null but the right child of the node has a value; in this case just append "()" for the left child and then call the right child 
using recursive call as usual; this is necessary because it helps define the tree structure in accordance to the question.
*/

public class ConstructStringFromBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        preorderTraversal(root, sb);
        return sb.toString();
    }

    private void preorderTraversal(TreeNode root, StringBuilder sb) {
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            preorderTraversal(root.left, sb);
            sb.append(")");
        }

        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            preorderTraversal(root.right, sb);
            sb.append(")");
        }
    }
}
