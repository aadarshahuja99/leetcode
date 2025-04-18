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
    // kadane's algorithm on a binary tree
    public int maxPathSum(TreeNode root) {
        int[] max = new int[] { Integer.MIN_VALUE };
        dfs(root, max);
        return max[0];
    }
    private int dfs(TreeNode current, int[] max)
    {
        if(current == null)
        {
            return 0;
        }
        int leftTreeSum = dfs(current.left, max);
        int rightTreeSum = dfs(current.right, max);
        int currentSum = leftTreeSum + rightTreeSum + current.val;
        max[0] = Math.max(max[0], currentSum);
        int valueToBeReturned = current.val + Math.max(rightTreeSum, leftTreeSum);
        return Math.max(0, valueToBeReturned); // kandane on trees
    }
}