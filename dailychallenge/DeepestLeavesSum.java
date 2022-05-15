/*
Problem:
Given the root of a binary tree, return the sum of values of its deepest leaves.

Link: https://leetcode.com/problems/deepest-leaves-sum/

Solution:
Level order traversal / BFS
*/

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            sum = 0;
            for (int size = queue.size(); size > 0; size--) {
                TreeNode curr = queue.remove();
                sum += curr.val;

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        return sum;
    }
}