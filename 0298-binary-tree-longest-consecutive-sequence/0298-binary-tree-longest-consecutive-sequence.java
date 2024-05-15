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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode current)
    {
        if(current.left == null && current.right == null)
        {
            return 1;
        }
        int left = 0;
        int right = 0;
        int ans = 1;
        if(current.left != null)
        {
            left = dfs(current.left);
            if(current.left.val == current.val + 1)
            {
                ans = Math.max(ans, 1 + left);
            }
        }
        if(current.right != null)
        {
            right = dfs(current.right);
            if(current.right.val == current.val + 1)
            {
                ans = Math.max(ans, 1 + right);
            }
        }
        max = Math.max(ans, max);
        // System.out.println(left+" "+right+" "+ans+" for node: "+current.val+" max: "+max);
        return ans;
    }
}