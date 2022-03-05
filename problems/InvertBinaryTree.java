/*
Problem:
Given the root of a binary tree, invert the tree, and return its root.

Link: https://leetcode.com/problems/invert-binary-tree/

Solution:
Level order traversal, change the links of right and left child of each node.
*/

import java.util.*;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        TreeNode curr = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            curr = queue.remove();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
                
            if(curr.left != null) {
                queue.add(curr.left);
            }
                
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
        
        return root;
    }   
}
