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
    long ans = 0;
    int modulo = 1000000007;
    long total = 0;
    public int maxProduct(TreeNode root) {
        dfsForTotalSum(root);
        dfs(root);
        return (int)(ans%modulo);
    }
    private void dfsForTotalSum(TreeNode current)
    {
        if(current == null)
        {
            return;
        }
        dfsForTotalSum(current.left);
        dfsForTotalSum(current.right);
        total += current.val;
        return;
    }

    private int dfs(TreeNode current)
    {
        if(current == null)
        {
            return 0;
        }
        int left = dfs(current.left);
        int right = dfs(current.right);
        int currentSum = current.val + left + right;
        ans = Math.max(ans, 1L*currentSum*(total - currentSum));
        return currentSum;
    }
}