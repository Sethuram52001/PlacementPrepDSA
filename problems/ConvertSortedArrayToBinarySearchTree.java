/*
Problem:
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced 
binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never 
differs by more than one.

Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Solution:
We can construct the tree in a recursive fashion:
root = nums[mid]
root.left = construct(nums, l, mid - 1)
root.right = construct(nums, mid + 1, r)
*/

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = constructBST(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode constructBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = constructBST(nums, l, m - 1);
        root.right = constructBST(nums, m + 1, r);

        return root;
    }
}