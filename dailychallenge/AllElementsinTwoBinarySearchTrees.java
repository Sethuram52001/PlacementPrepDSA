/*
Problem:
Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

Solution:
We can just do a inorder traversal on both trees and merge the list.
*/

import java.util.*;

public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        inorder(root1, q1);
        inorder(root2, q2);

        List<Integer> allElements = new ArrayList<>();
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q1.isEmpty()) {
                allElements.add(q2.poll());
            } else if (q2.isEmpty()) {
                allElements.add(q1.poll());
            } else {
                int val = q1.peek() < q2.peek() ? q1.poll() : q2.poll();
                allElements.add(val);
            }
        }

        return allElements;
    }

    private void inorder(TreeNode root, Queue<Integer> queue) {
        if (root != null) {
            if (root.left != null) {
                inorder(root.left, queue);
            }
            queue.add(root.val);
            if (root.right != null) {
                inorder(root.right, queue);
            }
        }
    }
}