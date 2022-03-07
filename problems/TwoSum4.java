/*
Problem:
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the 
BST such that their sum is equal to the given target.

Link: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

Solution:
i. We can inorder traversal, and use 2 pointers to search in the inorder list.
ii. We can use classic dfs with set, which will work for non-bst too.
iii. binary search

detailed explaination: https://leetcode.com/problems/two-sum-iv-input-is-a-bst/discuss/106059/JavaC%2B%2B-Three-simple-methods-choose-one-you-like
*/

public class TwoSum4 {
    // binary search
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }
    
    private boolean dfs(TreeNode root, TreeNode curr, int k) {
        if(curr == null) {
            return false;
        }
        
        return search(root, curr, k - curr.val) || dfs(root, curr.left, k) || dfs(root, curr.right, k);
    }
    
    private boolean search(TreeNode root, TreeNode curr, int k) {
        if (root == null) {
            return false;
        }

        return (root.val == k && root != curr) || (root.val < k && search(root.right, curr, k))
                || (root.val > k && search(root.left, curr, k));
    }
    
    // works for non-bst
    public boolean findTargetBT(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTargetBT(root, k, set);
    }
    
    private boolean findTargetBT(TreeNode root, int k, HashSet<Integer> set) {
        if(root == null) {
            return false;
        }
        
        if(set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        
        return findTargetBT(root.left, k, set) || findTargetBT(root.right, k, set);
    }
}
