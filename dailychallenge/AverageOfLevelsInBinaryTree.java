/*
Problem:
Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. 
Answers within 10-5 of the actual answer will be accepted. 

Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/

Solution:
Do a level order traversal, while doing so keep track of the total value of the level and number
of nodes in that level.
*/

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageLevels = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double levelTotal = 0;
            int size_ = queue.size();
            for (int size = size_; size > 0; size--) {
                TreeNode curr = queue.remove();

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }

                levelTotal += curr.val;
            }
            averageLevels.add(levelTotal / size_);
        }

        return averageLevels;
    }
}