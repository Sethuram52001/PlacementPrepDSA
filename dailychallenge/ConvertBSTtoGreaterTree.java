/*
Problem:
Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is 
changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

* The left subtree of a node contains only nodes with keys less than the node's key.
* The right subtree of a node contains only nodes with keys greater than the node's key.
* Both the left and right subtrees must also be binary search trees.

Link: https://leetcode.com/problems/convert-bst-to-greater-tree/

Solution:
If we observer closely, we're basically finding updating cumulative sum of each node's value in inorder order traversal from reverse.
So, we can basically do a reverse inorder traversal to achieve this, either using recursion or stack.
*/

public class ConvertBSTtoGreaterTree {
    private int cumSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            cumSum += root.val;
            root.val = cumSum;
            convertBST(root.left);
        }
        return root;
    }

    public TreeNode convertBST_(TreeNode root) {
        Deque<TreeNode> st = new ArrayDeque<>();
        int cumSum = 0;
        TreeNode curr = root;

        while (!st.isEmpty() || curr != null) {
            while (curr != null) {
                st.push(curr);
                curr = curr.right;
            }

            curr = st.pop();
            cumSum += curr.val;
            curr.val = cumSum;

            curr = curr.left;
        }

        return root;
    }
}