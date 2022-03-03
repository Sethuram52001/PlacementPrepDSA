/*
Problem:
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the 
set of nodes visible when the tree is viewed from the top.

Link: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

Solution:
We will maintain the levels of each node from left to right,
and update the value of each level while traversing the tree in level order fashion.
*/

import java.util.*;

class Pair {
    Node node;
    int verticalLevel;
    
    Pair(Node node, int verticalLevel) {
        this.node = node;
        this.verticalLevel = verticalLevel;
    }
    
    Node getKey() {
        return node;
    }
    
    int getValue() {
        return verticalLevel;
    }
}

public class TopViewOfBinaryTree {
    static ArrayList<Integer> topView(Node root) {
        // add your code
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 0));

        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> topView = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair currPair = queue.remove();
            Node curr = currPair.getKey();
            int verticalLevel = currPair.getValue();

            if (!map.containsKey(verticalLevel)) {
                map.put(verticalLevel, curr.data);
            }

            if (curr.left != null) {
                queue.add(new Pair(curr.left, verticalLevel - 1));
            }

            if (curr.right != null) {
                queue.add(new Pair(curr.right, verticalLevel + 1));
            }
        }

        for (Integer val : map.values()) {
            topView.add(val);
        }

        return topView;
    }
}