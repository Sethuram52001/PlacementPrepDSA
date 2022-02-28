/*
Problem:
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. 
You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as 
the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.

Note: The merging process must start from the root nodes of both trees.

Link: https://leetcode.com/problems/merge-two-binary-trees/

Solution:
Recursive: We can traverse both the given trees in a preorder fashion. At every step, we check if the current node exists(isn't null) for both the trees. 
If so, we add the values in the current nodes of both the trees and update the value in the current node of the first tree to reflect this sum obtained.

Iterative: 
In the current approach, we again traverse the two trees, but this time we make use of a stackstack to do so instead of making use of recursion. 
Each entry in the stack stores data in the form [node_{tree1}, node_{tree2}].
*/

public class MergeTwoBinaryTrees {
    public TreeNode mergeTreesRecursive(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }
    
    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        
        t1.val += t2.val;
        t1.left = merge(t1.left, t2.left);
        t1.right = merge(t1.right, t2.right);
        
        return  t1;
    }

    public TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
        if(root1 == null) {
            return root2;
        }
        
        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[]{root1, root2});
        
        while(!st.isEmpty()) {
            TreeNode[] t = st.pop();
            if(t[0] == null || t[1] == null) {
                continue;
            }
            
            t[0].val += t[1].val;
            
            if(t[0].left == null) {
                t[0].left = t[1].left;
            }
            else {
                st.push(new TreeNode[]{t[0].left, t[1].left});
            }
            
            if(t[0].right == null) {
                t[0].right = t[1].right;
            }
            else {
                st.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        
        return root1;
    }
}