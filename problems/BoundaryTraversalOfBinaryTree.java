/*
Problem:
You have been given a binary tree of integers. Your task is to print the boundary nodes of this binary 
tree in Anti-Clockwise direction starting from the root node.

Link: https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

Solution:
We can separate the traversal into 3 parts - left boundary, leaves and right boundary.
1. First we add the nodes present in the left boundary except for the leaf node.
2. Next we add leaf nodes using preorder traversal.
3. Finally we add the right boundary nodes using a temporary list and reverse it before adding
   to the final list because it's anti-clockwise.
*/

/************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.*;

public class BoundaryTraversalOfBinaryTree {
    private static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> boundaryTraversal) {
        root = root.left;
        while (root != null) {
            if (!isLeaf(root)) {
                boundaryTraversal.add(root.data);
            }

            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private static void addLeaves(TreeNode root, ArrayList<Integer> boundaryTraversal) {

        if (isLeaf(root)) {
            boundaryTraversal.add(root.data);
        }
        if (root.left != null) {
            addLeaves(root.left, boundaryTraversal);
        }
        if (root.right != null) {
            addLeaves(root.right, boundaryTraversal);
        }
    }

    private static void addRightBoundary(TreeNode root, ArrayList<Integer> boundaryTraversal) {
        root = root.right;
        List<Integer> temp = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) {
                temp.add(root.data);
            }

            if (root.right != null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            boundaryTraversal.add(temp.get(i));
        }
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        // Write your code here.
        ArrayList<Integer> boundaryTraversal = new ArrayList<>();
        if (root == null) {
            return boundaryTraversal;
        }

        if (!isLeaf(root)) {
            boundaryTraversal.add(root.data);
        }
        addLeftBoundary(root, boundaryTraversal);
        addLeaves(root, boundaryTraversal);
        addRightBoundary(root, boundaryTraversal);

        return boundaryTraversal;
    }
}