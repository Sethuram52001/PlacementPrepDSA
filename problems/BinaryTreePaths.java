/*
Problem:
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.

Link: https://leetcode.com/problems/binary-tree-paths/

Solution:
DFS
*/

import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> BTPaths = new ArrayList<>();
        dfs(root, "", BTPaths);
        return BTPaths;
    }
    
    private void dfs(TreeNode root, String path, List<String> BTPaths) {
        if(root.left == null && root.right == null) {
            BTPaths.add(path + root.val);
            return;
        }
        
        if(root.left != null) {
            dfs(root.left, path + root.val + "->", BTPaths);
        }
        
        if(root.right != null) {
            dfs(root.right, path + root.val + "->", BTPaths);
        }
    }   
}