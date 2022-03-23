/*
Problem:
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
(i.e., from left to right, then right to left for the next level and alternate between).

Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

Solution:
level order traversal with condition check for zigzag
*/

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagTraversal = new ArrayList<>();
        if (root == null) {
            return zigzagTraversal;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode curr = queue.remove();
                if (depth % 2 == 0) {
                    level.add(0, curr.val);
                } else {
                    level.add(curr.val);
                }

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            zigzagTraversal.add(new ArrayList<>(level));
            depth++;
        }

        return zigzagTraversal;
    }
}