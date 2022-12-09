/*
Problem:
Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b 
where v = |a.val - b.val| and a is an ancestor of b.
A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/

Solution:
We pass the minimum and maximum values to the children,
At the leaf node, we can track of  max - min through the path from the root to the leaf.
*/

public class MaximumDifferenceBetweenNodeAndAncestor {
    int maxDiff;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return maxDiff;
        }

        maxDiff = 0;
        helper(root, root.val, root.val);
        return maxDiff;
    }

    private void helper(TreeNode curr, int currMin, int currMax) {
        if (curr == null) {
            return;
        }

        int diff = Math.max(Math.abs(curr.val - currMin), Math.abs(curr.val - currMax));
        maxDiff = Math.max(maxDiff, diff);
        currMin = Math.min(currMin, curr.val);
        currMax = Math.max(currMax, curr.val);
        helper(curr.left, currMin, currMax);
        helper(curr.right, currMin, currMax);
    }
}
