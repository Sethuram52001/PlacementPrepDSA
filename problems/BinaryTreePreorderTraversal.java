/*
Problem:
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

Solution:
preorder traversal: root - left - right
We can use either use a recursive approach or use a stack to do it in iterative fashion.
*/

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);
        
        while(!st.isEmpty()) {
            curr = st.pop();
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
        if(root == null) {
            return;
        }
        preorder.add(root.val);
        if(root.left != null) {
            preorderTraversal(root.left, preorder);
        }
        if(root.right != null) {
            preorderTraversal(root.right, preorder);
        }
    }   
}