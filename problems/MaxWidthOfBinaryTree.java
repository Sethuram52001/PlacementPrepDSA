/*
Problem:
Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null 
nodes), where the null nodes between the end-nodes are also counted into the length calculation.

Link: https://leetcode.com/problems/maximum-width-of-binary-tree/

Solution:
The idea is to traverse all the node in the tree in level order(Here I use one Queue to store each level's nodes. The time I traverse each level is 
the queue's size(the number of nodes from upper level)). Each time a node is traversed, the position of the node(as it is in a full binary tree) is 
stored in the HashMap. If the position of the parent node is 'n', then the left child is '2 * n' and the right child is '2 * n + 1'. The width of each 
level is the last node's position in this level subtracts the first node's position in this level plus 1.
*/

public class MaxWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> idxQueue = new ArrayDeque<>();
        queue.add(root);
        idxQueue.add(1);
        
        int maxWidth = 0;
        int start = 0, end = 0;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                int currIdx = idxQueue.remove();
                
                if(curr.left != null) {
                    queue.add(curr.left);
                    idxQueue.add(currIdx*2);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                    idxQueue.add(currIdx*2 + 1);
                }
                
                start = i == 0 ? currIdx : start;
                end = i == size - 1 ? currIdx : end;
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        
        return maxWidth;
    }    
}
