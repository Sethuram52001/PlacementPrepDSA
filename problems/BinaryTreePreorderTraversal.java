/*
Problem:
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

Solution:
preorder: root - left - right
*/

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            if(curr != null) {
                preorder.add(curr.val);            
                st.push(curr.right);
                st.push(curr.left);
            }
        }
        
        return preorder;
    }

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        return preorder;
    }
    
    private void preorderTraversal(TreeNode root, List<Integer> preorder) {
        if(root != null) {
            preorder.add(root.val);
            
            if(root.left != null) {
                preorderTraversal(root.left, preorder);
            }
            
            if(root.right != null) {
                preorderTraversal(root.right, preorder);
            }
        }
    }
}