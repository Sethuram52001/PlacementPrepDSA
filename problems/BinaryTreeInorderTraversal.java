/*
Problem:
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Link: https://leetcode.com/problems/binary-tree-inorder-traversal/ 

Solution:
inorder: left - root - right
*/

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        
        while(curr != null || !st.isEmpty()) {
            while(curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            
            curr = st.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }
        
        return inorder;
    }

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return inorder;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if(root != null) {
            if(root.left != null) {
                inorderTraversal(root.left, inorder);
            }

            inorder.add(root.val);

            if(root.right != null) {
                inorderTraversal(root.right, inorder);
            }
        }
    }
}