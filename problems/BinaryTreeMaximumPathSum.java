/*
Problem:
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an 
edge connecting them. A node can only appear in the sequence at most once. Note that the path does not 
need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.

Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

Solution:
1. https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/389609/Full-Explanation-article-with-pseudo-code-Beats-JAVA-100-time-and-100-space-Solution
2. https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram
*/

public class BinaryTreeMaximumPathSum {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPathHelper(root);
        return maxSum;
    }

    private int maxPathHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = maxPathHelper(root.left);
        int rightPath = maxPathHelper(root.right);

        int maxLeftRight = Math.max(leftPath, rightPath);
        int maxOnePathRoot = Math.max(root.val, root.val + maxLeftRight);
        int maxAllPathRoot = Math.max(maxOnePathRoot, leftPath + rightPath + root.val);

        maxSum = Math.max(maxSum, maxAllPathRoot);
        return maxOnePathRoot;
    }
}