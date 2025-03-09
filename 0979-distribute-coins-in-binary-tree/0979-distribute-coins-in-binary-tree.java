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
    public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }
    private int dfs(TreeNode current, int[] ans)
    {
        if(current == null)
        {
            return 0;
        }
        
        int left = dfs(current.left, ans);
        int right = dfs(current.right, ans);

        ans[0] += Math.abs(left) + Math.abs(right); // add the moves from left and right subtrees to the answer

        // return the total surplus/deficit of the subtree rooted at node 'current'
        // if current node has one coin, then current.val - 1 is 0, implying no moves are needed for the current node
        // if current.val > 1, then some outgoing moves will be needed for current node
        // similarly, if current.val < 1, incoming moves will be needed
        // left and right are added because the current node's dfs method will return the net incoming/outgoings
        // that will be needed to make the tree rooted at the current node balanced
        return (current.val - 1) + left + right;
    }
}