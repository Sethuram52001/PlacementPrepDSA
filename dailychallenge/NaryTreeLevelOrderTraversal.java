/*
Problem:
Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, 
each group of children is separated by the null value (See examples).

Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/

Solution:
BFS
*/
import java.util.*;

public class NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            for (int size = queue.size(); size > 0; size--) {
                Node curr = queue.remove();
                level.add(curr.val);

                List<Node> children = curr.children;
                for (Node child : children) {
                    queue.add(child);
                }
            }
            levelOrderTraversal.add(level);
        }

        return levelOrderTraversal;
    }
}