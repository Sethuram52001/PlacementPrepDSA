/*
Problem:
Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.

Note that the root node is at depth 1.

The adding rule is:

Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
cur's original left subtree should be the left subtree of the new left subtree root.
cur's original right subtree should be the right subtree of the new right subtree root.
If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.

Link: https://leetcode.com/problems/add-one-row-to-tree/

Solution:
While doing bfs add the new row at depth d and change add links of depth - 1 to the newly added row of nodes.
*/
import java.util.*;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        for (int level = 1; level < depth - 1; level++) {
            for (int size = queue.size(); size > 0; size--) {
                TreeNode curr = queue.remove();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }

        for (int size = queue.size(); size > 0; size--) {
            TreeNode curr = queue.remove();
            TreeNode currLeft = curr.left;
            TreeNode currRight = curr.right;
            curr.left = new TreeNode(val);
            curr.right = new TreeNode(val);
            curr.left.left = currLeft;
            curr.right.right = currRight;
        }

        return root;
    }
}