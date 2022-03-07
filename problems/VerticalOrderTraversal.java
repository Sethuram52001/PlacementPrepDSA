/*
Problem:
Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. 
The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and 
ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree.

Link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

Solution:
We should maintain both vertical level and horizontal level of every node.
*/

import java.util.*;

class Tuple {
    TreeNode node;
    int verticalLevel, horizontalLevel;
    
    Tuple(TreeNode node, int verticalLevel, int horizontalLevel) {
        this.node = node;
        this.verticalLevel = verticalLevel;
        this.horizontalLevel = horizontalLevel;
    }
}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode curr = tuple.node;
            int verticalLevel = tuple.verticalLevel;
            int horizontalLevel = tuple.horizontalLevel;

            if (!map.containsKey(verticalLevel)) {
                map.put(verticalLevel, new TreeMap<>());
            }

            if (!map.get(verticalLevel).containsKey(horizontalLevel)) {
                map.get(verticalLevel).put(horizontalLevel, new PriorityQueue<>());
            }

            map.get(verticalLevel).get(horizontalLevel).add(curr.val);

            if (curr.left != null) {
                queue.add(new Tuple(curr.left, verticalLevel - 1, horizontalLevel + 1));
            }

            if (curr.right != null) {
                queue.add(new Tuple(curr.right, verticalLevel + 1, horizontalLevel + 1));
            }
        }

        List<List<Integer>> verticalTraversal = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> key : map.values()) {
            verticalTraversal.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : key.values()) {
                while (!nodes.isEmpty()) {
                    verticalTraversal.get(verticalTraversal.size() - 1).add(nodes.poll());
                }
            }
        }

        return verticalTraversal;
    }
}