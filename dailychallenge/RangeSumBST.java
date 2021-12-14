/*
Problem:
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with 
a value in the inclusive range [low, high].

Link: https://leetcode.com/problems/range-sum-of-bst/

Solution:
We can follow a recursive approach, we know that left leaf is less than root node and right node is more than root node in a BST
*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root == null) {
            return sum;
        }
        
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        return sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
