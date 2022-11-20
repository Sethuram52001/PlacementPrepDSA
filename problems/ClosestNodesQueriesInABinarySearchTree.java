/*
Problem:
You are given the root of a binary search tree and an array queries of size n consisting of positive integers.

Find a 2D array answer of size n where answer[i] = [mini, maxi]:

mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, 
add -1 instead.
maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, 
add -1 instead.
Return the array answer.

Link: https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/

Solution:
Intuition:
Since, the given tree is a binary seach tree, we can get values of the nodes in sorted order just by doing an inordrer traversal. So, now
we can easily perform the queries on the sorted list easily either using binary search or a datastructure like treeset.

Approach using TreeSet:
First, add all values from the tree to a list using any tree traversal algorithm. Now, add the list of values to a treeset.
Next, we can use
i. ceiling: to find a element greater or equal to the given query
ii. floor: to find a element lesser or equal to the given query

Reference:
i. https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/solutions/2831808/tree-traversal-treeset/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

public class ClosestNodesQueriesInABinarySearchTree {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sortedList = new ArrayList<>();
        inorder(root, sortedList);
        TreeSet<Integer> set = new TreeSet<>();
        set.addAll(sortedList);

        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> temp = new ArrayList<>();
            int low = set.floor(query) != null ? set.floor(query) : -1;
            int high = set.ceiling(query) != null ? set.ceiling(query) : -1;
            temp.add(low);
            temp.add(high);
            res.add(new ArrayList<>(temp));
        }

        return res;
    }

    private void inorder(TreeNode root, List<Integer> sortedList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorder(root.left, sortedList);
        }

        sortedList.add(root.val);

        if (root.right != null) {
            inorder(root.right, sortedList);
        }
    }
}
