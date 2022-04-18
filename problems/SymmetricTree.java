/*
Problem:
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Link: https://leetcode.com/problems/symmetric-tree/

Solution:
The idea is simple, we're going to traverse the left side and right side of the
binary tree separately, while doing so, we check for the symmetric condition.

For this traversal, we'll make use of a queue:
queue.add(root) // left half
queue.add(root) // right half

check condition

queue.add(curr1.left)
queue.add(curr2.right)
queue.add(curr1.right)
queue.add(curr2.left)
*/

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.remove();
            TreeNode curr2 = queue.remove();

            if (curr1 == null && curr2 == null) {
                continue;
            }

            if (curr1 == null || curr2 == null) {
                return false;
            }

            if (curr1.val != curr2.val) {
                return false;
            }

            queue.add(curr1.left);
            queue.add(curr2.right);
            queue.add(curr1.right);
            queue.add(curr2.left);
        }

        return true;
    }
}