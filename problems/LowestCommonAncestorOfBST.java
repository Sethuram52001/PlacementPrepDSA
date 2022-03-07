/*
Problem:
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p 
and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant 
of itself).”

Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

Solution:
We can traverse according to the condition to get the ancestor node:
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            
            else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            
            else {
                return root;
            }
*/

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(true) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            
            else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            
            else {
                return root;
            }
        }
    }
}