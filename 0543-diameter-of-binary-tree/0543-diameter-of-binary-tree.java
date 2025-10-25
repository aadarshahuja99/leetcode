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
    int ans = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode current)
    {
        if(current == null)
        {
            return 0;
        }
        int leftHeight = dfs(current.left);
        int rightHeight = dfs(current.right);
        ans = Math.max(ans, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}