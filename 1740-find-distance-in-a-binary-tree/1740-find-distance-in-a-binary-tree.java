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
    int ans = 0;
    public int findDistance(TreeNode root, int p, int q) {
        int val = getLCAAndComputeAns(root, 0, p, q);
        return ans;
    }
    // optimal one pass solution, key insight: pass depth as a param to dfs
    private int getLCAAndComputeAns(TreeNode current, int currentDepth, int p, int q)
    {
        if(current == null)
        {
            return -1;
        }
        int left = getLCAAndComputeAns(current.left, currentDepth+1, p, q);
        int right = getLCAAndComputeAns(current.right, currentDepth+1, p, q);
        int max = Math.max(left, right);
        if(current.val == p || current.val == q)
        {
            if(max != -1)
            {
                ans = max - currentDepth;
            }
            return currentDepth;
        }
        if(left != -1 && right != -1)
        {
            ans = left + right - 2*currentDepth;
            return currentDepth; 
        }
        if(left != -1)
        {
            return left;
        }
        return right;
    }
}