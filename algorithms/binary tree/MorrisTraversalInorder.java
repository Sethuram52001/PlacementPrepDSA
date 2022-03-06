/*
 * Morris Traversal:
 * In this method, we have to use a new data structure-Threaded Binary Tree, and the strategy is as follows:
 * Step 1: Initialize current as root
 * Step 2: While current is not NULL,
    If current does not have left child
    a. Add current’s value
    b. Go to the right, i.e., current = current.right

    Else
    a. In current's left subtree, make current the right child of the rightmost node
    b. Go to this left child, i.e., current = current.left

 * Time complexity: O(N)
 * Space complexity: O(1) 
 */

public class MorrisTraversalInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        TreeNode curr = root, prev = null;
        
        while(curr != null) {
            if(curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            }
            else {
                prev = curr.left;
                while(prev.right != null) {
                    prev = prev.right;
                }
                
                prev.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
        
        return inorder;
    }   
}