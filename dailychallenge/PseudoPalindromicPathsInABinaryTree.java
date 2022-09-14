/*
Problem:
Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one 
permutation of the node values in the path is a palindrome.

Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

Link: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/

Solution:
We can do a simple trick for checking palindrome while traversing the tree from root to leaf using dfs.
The trick - bit manipulation:
path = path ^ (1 << node.val)

while doing so, we can check whether there bits set with odd frequency using 1's complement, and count if it
is a palindrome.
*/

public class PseudoPalindromicPathsInABinaryTree {
    int count;

    public int pseudoPalindromicPaths(TreeNode root) {
        this.count = 0;
        rootToLeafTraversal(root, 0);
        return count;
    }

    private void rootToLeafTraversal(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum ^= 1 << root.val;
            count += isOneBitSet(sum) ? 1 : 0;
        }

        rootToLeafTraversal(root.left, sum ^ (1 << root.val));
        rootToLeafTraversal(root.right, sum ^ (1 << root.val));
    }

    private boolean isOneBitSet(int x) {
        return (x & (x - 1)) == 0;
    }
}
