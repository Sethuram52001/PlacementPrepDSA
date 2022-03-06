/**
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

public class MorrisTraversalPreorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        
        while(curr != null) {
            if(curr.left == null) {
                preorder.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode prev = curr.left;
                
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                
                if(prev.right == null) {
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                }
                
                else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        
        return preorder;
    }    
}
