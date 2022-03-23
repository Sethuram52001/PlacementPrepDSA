/*
Problem:
Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of 
the nodes you can see ordered from top to bottom.

Link: https://leetcode.com/problems/binary-tree-right-side-view/

Solution:
We can use dfs and traverse the tree similar to preorder but start from right, such that:
root-right-left
*/

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideNodes = new ArrayList<>();
        rightSideView(root, 0, rightSideNodes);
        return rightSideNodes;
    }

    private void rightSideView(TreeNode curr, int depth, List<Integer> rightSideNodes) {
        if (curr == null) {
            return;
        }

        if (depth == rightSideNodes.size()) {
            rightSideNodes.add(curr.val);
        }

        rightSideView(curr.right, depth + 1, rightSideNodes);
        rightSideView(curr.left, depth + 1, rightSideNodes);
    }
}