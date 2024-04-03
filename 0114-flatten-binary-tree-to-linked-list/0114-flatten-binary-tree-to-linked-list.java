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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        // root left right, so in recursion we have to do right left root
        dfs(root);
    }
    private void dfs(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        dfs(root.right);
        dfs(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}