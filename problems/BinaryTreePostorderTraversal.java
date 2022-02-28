/*
Problem:
Given the root of a binary tree, return the postorder traversal of its nodes' values.

Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

Solution:
postorder: left - right - root
*/

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if(root == null) {
            return postorder;
        }
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(curr);
        
        while(!st.isEmpty()) {
            curr = st.pop();
            postorder.add(0, curr.val);
            
            if(curr.left != null) {
                st.push(curr.left);
            }
            
            if(curr.right != null) {
                st.push(curr.right);
            }
        }
        
        return postorder;
    }
    
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(root, postorder);
        return postorder;
    }
    
    private void postorderTraversal(TreeNode root, List<Integer> postorder) {
        if(root != null) {
            if(root.left != null) {
                postorderTraversal(root.left, postorder);
            }
            if(root.right != null) {
                postorderTraversal(root.right, postorder);
            }
            postorder.add(root.val);
        }
    }
}