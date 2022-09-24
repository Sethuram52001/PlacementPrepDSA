/*
Problem:
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the 
sum of the node values in the path equals targetSum. Each path should be returned as a list of the 
node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node 
with no children.

Link: https://leetcode.com/problems/path-sum-ii/

Solution:
DFS + backtracking
*/
import java.util.*;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null) {
            return paths;
        }
        
        Stack<Integer> path = new Stack<>();
        DFS(root, targetSum, path, paths);
        return paths;
    }
    
    private void DFS(TreeNode root, int targetSum, Stack<Integer> path, List<List<Integer>> paths) {
        path.push(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) {
            paths.add(new ArrayList<>(path));
        }
        
        if(root.left != null) {
            DFS(root.left, targetSum - root.val, path, paths);
        }
        
        if(root.right != null) {
            DFS(root.right, targetSum - root.val, path, paths);
        }
        path.pop();                                                                                            
    }
}
