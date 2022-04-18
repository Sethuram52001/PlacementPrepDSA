/*
Problem:
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the 
values of the nodes in the tree.

Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Solution:
We can do inorder traversal and keep track of the number of nodes explored.
*/

import java.util.*;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}