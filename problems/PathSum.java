/*
Problem:
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf 
path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

Link: https://leetcode.com/problems/path-sum/submissions/

Solution:
DFS
*/

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }   
}