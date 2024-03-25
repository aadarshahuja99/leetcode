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
    HashMap<TreeNode,Integer> remSums;
    long ans = 0;
    int modulo = 1000000007;
    public int maxProduct(TreeNode root) {
        childSums = new HashMap<>();
        remSums = new HashMap<>();
        remSums.put(root,0);
        dfs(root);
        getAns(root.left,root);
        getAns(root.right,root);
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
        childSums.put(current, left+right);
        return current.val + left + right;
    }
    private void getAns(TreeNode current, TreeNode parent)
    {
        if(current == null)
        {
            return;
        }
        int remSum = parent.val + remSums.get(parent) + childSums.get(parent) - childSums.get(current) - current.val;
        remSums.put(current,remSum);
        // System.out.println(current.val+" "+(childSums.get(current))+" "+remSum);
        long candidate = (1L*(childSums.get(current)+current.val)*remSums.get(current));
        ans = Math.max(ans, candidate);
        getAns(current.left,current);
        getAns(current.right, current);
    }
}