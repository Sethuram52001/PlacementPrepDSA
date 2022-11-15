/*
Problem:
Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a 
complete binary tree, and all nodes in the last level are as far left as possible. It can have 
between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

Link: https://leetcode.com/problems/count-complete-tree-nodes/description/

Solution: 
Suppose there are N nodes in a tree, Then depth=(log2(n+1))

1 node gives log2(2) = 1
3 nodes gives log2(4) = 2
7 nodes gives log2(8) = 3
15 nodes gives log2(16) = 4

what we are doing in this line (1 << leftDepth) - 1 is given Depth we will find Number of nodes,
N = (2^depth-)1.
*/

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);

        if(leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.left;
            depth++;
        }

        return depth;
    }

    private int rightDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            root = root.right;
            depth++;
        }

        return depth;
    }
}
