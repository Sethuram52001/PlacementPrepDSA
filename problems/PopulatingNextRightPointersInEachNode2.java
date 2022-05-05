/*
Problem:
Given a binary tree, populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

Solution:
BFS/level - order traversal
To avoid extra space by using queue, we can maintain 2 pointers one to level another for traversing
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.*;

public class PopulatingNextRightPointersInEachNode2 {
    public Node connect(Node root) {
        connectHelper(root);
        return root;
    }
    
    private void connectHelper(Node root) {
        while (root != null) {
            Node temp = new Node();
            Node curr = temp;

            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }

                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }

                root = root.next;
            }

            root = temp.next;
        }
    }

    public Node connect_ExtraSpace(Node root) {
        if(root == null) {
            return root;
        }
        
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            for(int size = queue.size(); size > 0; size--) {
                Node curr = queue.remove();
                if(size == 1) {
                    curr.next = null;
                }
                else {
                    curr.next = queue.peek();   
                }
                
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        
        return root;
    }  
}