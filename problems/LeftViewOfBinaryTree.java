/*
Problem:
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. 
The task is to complete the function leftView(), which accepts root of the tree as argument.

Link: https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1#

Solution:
We will do a level order recursively in such a way that we maintain the space complexity of O(H), H - height of the tree.
*/

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class LeftViewOfBinaryTree {
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> leftViewNodes = new ArrayList<>();
        leftView(leftViewNodes, root, 0);
        return leftViewNodes;
    }

    private void leftView(ArrayList<Integer> leftViewNodes, Node curr, int currDepth) {
        if (curr == null) {
            return;
        }

        if (currDepth == leftViewNodes.size()) {
            leftViewNodes.add(curr.data);
        }

        leftView(leftViewNodes, curr.left, currDepth + 1);
        leftView(leftViewNodes, curr.right, currDepth + 1);
    }
}