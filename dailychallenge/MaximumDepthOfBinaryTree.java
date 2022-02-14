/*
Problem:
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

Solution:
We can do either BFS or DFS on the binary tree.
*/

import java.util.*;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthBFS(TreeNode root) {
        if(root == null) {
            return 0;    
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        int level = 0;
        while(!q.isEmpty()) {
            for(int size = q.size(); size > 0; size--) {
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            level++;
        }
        
        return level;
    }   
}