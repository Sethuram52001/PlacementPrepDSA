/*
Problem:
Given a Binary Tree A containing N nodes.

You need to find the path from Root to a given node B.

NOTE:
* No two nodes in the tree have same data values.
* You can assume that B is present in the tree A and a path always exists.

Link: https://www.interviewbit.com/problems/path-to-given-node/

Solution:
DFS - a recursive function that traverses the different path in the binary tree to find the required node x.
If node x is present then it returns true and accumulates the path nodes in some array arr[]. Else it returns false.
*/

public class PathToGivenNode {
    public int[] solve(TreeNode A, int B) {
        List<Integer> path = new ArrayList<>();
        if(getPath(A, B, path)) {
            int[] ans = new int[path.size()];
            for(int i = 0; i < path.size(); i++) {
                ans[i] = path.get(i);
            }
            return ans;
        }
        return new int[0];
    }

    private boolean getPath(TreeNode curr, int targetNode, List<Integer> path) {
        if(curr == null) {
            return false;
        }

        path.add(curr.val);
        if(curr.val == targetNode) {
            return true;
        }

        if(getPath(curr.left, targetNode, path) || getPath(curr.right, targetNode, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}