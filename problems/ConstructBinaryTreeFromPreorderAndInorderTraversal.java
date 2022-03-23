/*
Problem:
Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the 
inorder traversal of the same tree, construct and return the binary tree.

Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

Solution:
We know that inorder traversal follows:
left-root-right

and preorder traversal follows:
root-left-right

So, we can say that the root from preorder has its left and right subtree values in the left of the root value present in inorder
and same can be said for right subtree.

Now, we can construct a recursive function based on this relation.
*/

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> inorderIdx;
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIdx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = buildTree(preorder, left, inorderIdx.get(root.val) - 1);
        root.right = buildTree(preorder, inorderIdx.get(root.val) + 1, right);

        return root;
    }
}