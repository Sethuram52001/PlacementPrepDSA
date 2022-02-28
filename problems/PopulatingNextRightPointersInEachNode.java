/*
Problem:
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

Solution:
We can travers in level order fashion, and to do in inplace, we have to manipulate the next level's node from the current level.
*/

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        Node levelStart = root;
        
        while(levelStart != null) {
            Node curr = levelStart;
            
            while(curr != null) {
                if(curr.left != null) {
                    curr.left.next = curr.right;
                } 
                if(curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
        return root;
    }
}