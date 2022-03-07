/*
Problem:
Given the root of a binary tree, return the level order traversal of its nodes' values. 
(i.e., from left to right, level by level).

Link: https://leetcode.com/problems/binary-tree-level-order-traversal/

Solution:
BFS
*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if(root == null) {
            return levels;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for(int size = queue.size(); size > 0; size--) {
                TreeNode curr = queue.remove();
                level.add(curr.val);
                
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            levels.add(new ArrayList<>(level));
        }
        
        return levels;
    } 
}