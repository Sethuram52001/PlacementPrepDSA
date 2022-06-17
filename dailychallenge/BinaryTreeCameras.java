/*
Problem:
You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a 
node can monitor its parent, itself, and its immediate children.
Return the minimum number of cameras needed to monitor all nodes of the tree.

Link: https://leetcode.com/problems/binary-tree-cameras/

Solution:
Instead of trying to cover every node from the top down, let's try to cover it from the bottom up - 
considering placing a camera with the deepest nodes first, and working our way up the tree.

If a node has its children covered and has a parent, then it is strictly better to place the camera 
at this node's parent.
*/

public class BinaryTreeCameras {
    int camera = 0;

    public enum Camera {
        HAS_CAMERA, COVERED, PLEASE_COVER
    };

    public int minCameraCover(TreeNode root) {
        return cover(root) == Camera.PLEASE_COVER ? ++camera : camera;
    }

    private Camera cover(TreeNode root) {
        if (root == null) {
            return Camera.COVERED;
        }

        Camera left = cover(root.left);
        Camera right = cover(root.right);

        if (left == Camera.PLEASE_COVER || right == Camera.PLEASE_COVER) {
            camera++;
            return Camera.HAS_CAMERA;
        }

        if (left == Camera.HAS_CAMERA || right == Camera.HAS_CAMERA) {
            return Camera.COVERED;
        }

        return Camera.PLEASE_COVER;
    }
}