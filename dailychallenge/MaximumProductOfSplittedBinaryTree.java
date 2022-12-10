/*
Problem:
Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of 
the sums of the subtrees is maximized.
Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
Note that you need to maximize the answer before taking the mod and not after taking it.

Link: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/

Solution:
If we know the sum of a subtree, the answer is max( (total_sum - subtree_sum) * subtree_sum) in each node.
*/

public class MaximumProductOfSplittedBinaryTree {
    long maxProd, totalSum, subSum;

    public int maxProduct(TreeNode root) {
        maxProd = 0;
        totalSum = 0;
        subSum = 0;
        totalSum = maxProductHelper(root);
        maxProductHelper(root);
        return (int) (maxProd % (int) (1e9 + 7));
    }

    private long maxProductHelper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        subSum = curr.val + maxProductHelper(curr.left) + maxProductHelper(curr.right);
        maxProd = Math.max(maxProd, subSum * (totalSum - subSum));
        return subSum;
    }
}
