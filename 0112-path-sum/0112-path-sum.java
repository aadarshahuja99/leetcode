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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }
    private boolean dfs(TreeNode current, int rem)
    {
        if(current == null)
        {
            return false;
        }
        if(current.left == null && current.right == null)
        {
            return rem == current.val;
        }
        var left = dfs(current.left, rem - current.val);
        var right = dfs(current.right, rem - current.val);
        return left | right;
    }
}