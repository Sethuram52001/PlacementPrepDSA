/*
Problem:
You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with 
the most significant bit.

For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

The test cases are generated so that the answer fits in a 32-bits integer.

Link: https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

Solution:
We can use bit manipulation to add the binary number, to traverse the tree we can use preorder traversal
*/

public class SumofRootToLeafBinaryNumbers {
    int rootSum = 0;

    public int sumRootToLeaf(TreeNode root) {
        solve(root, 0);
        return rootSum;
    }

    private void solve(TreeNode root, int sum) {
        if (root != null) {
            sum = ((sum << 1) | root.val);

            if (root.left == null && root.right == null) {
                rootSum += sum;
            }

            solve(root.left, sum);
            solve(root.right, sum);
        }
    }
}
