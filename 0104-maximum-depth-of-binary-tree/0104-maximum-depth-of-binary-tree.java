/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode current)
    {
        if(current == null)
        {
            return 0;
        }
        int leftTreeLength = dfs(current.left);
        int rightTreeLength = dfs(current.right);
        return 1 + Math.max(leftTreeLength, rightTreeLength);
    }
}