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
    public int longestZigZag(TreeNode root) {
        getAns(root);
        return ans;
    }
    // returns 0th val as right and 1st val as left
    private int[] getAns(TreeNode current)
    {
        int leftPath = 0;
        int rightPath = 0;
        if(current.right != null)
        {
            int[] rightChildVals = getAns(current.right);
            rightPath = 1 + rightChildVals[1];
        }
        if(current.left != null)
        {
            int[] leftChildVals = getAns(current.left);
            leftPath = 1 + leftChildVals[0];
        }
        ans = Math.max(ans, Math.max(leftPath, rightPath));
        return new int[] { rightPath, leftPath };
    }
}