/*
Problem:
Given a binary tree, print the bottom view from left to right.
A node is included in bottom view if it can be seen when we look at the tree from bottom.

Link: https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#

Solution:
We will maintain the levels of each node from left to right,
and update the value of each level while traversing the tree in level order fashion.
*/

/*
class Node {
    int data;
    int hd;
    Node left, right;

    Node(key) {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}
*/

import java.util.*;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> bottomView = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        root.hd = 0;
        
        while(!queue.isEmpty()) {
            for(int size = queue.size(); size > 0; size--) {
                Node curr = queue.remove();
                int verticalLevel = curr.hd;
                
                map.put(verticalLevel, curr.data);
                
                if(curr.left != null) {
                    queue.add(curr.left);
                    curr.left.hd = curr.hd - 1;
                }
                
                if(curr.right != null) {
                    queue.add(curr.right); 
                    curr.right.hd = curr.hd + 1;
                }
            }
        }
        
        for(Integer val : map.values()) {
            bottomView.add(val);
        }
        
        return bottomView;
    }   
}