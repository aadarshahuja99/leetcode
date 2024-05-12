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
    HashMap<TreeNode,Integer> childSums;
    long ans = 0;
    int modulo = 1000000007;
    public int maxProduct(TreeNode root) {
        childSums = new HashMap<>();
        dfs(root);
        int totalSum = childSums.get(root);
        for(Map.Entry<TreeNode,Integer> sumPair : childSums.entrySet())
        {
            long current = 1L*sumPair.getValue()*(1L*totalSum - 1L*sumPair.getValue());
            ans = Math.max(ans, current);
        }
        return (int)(ans%modulo);
    }
    private int dfs(TreeNode current)
    {
        if(current == null)
        {
            return 0;
        }
        int left = dfs(current.left);
        int right = dfs(current.right);
        childSums.put(current, left+right+current.val);
        return current.val + left + right;
    }
}