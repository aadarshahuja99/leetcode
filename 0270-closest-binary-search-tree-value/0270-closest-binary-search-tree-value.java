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
    public int closestValue(TreeNode root, double target) {
        TreeNode current = root;
        int min = Integer.MAX_VALUE;
        double minDiff = Double.MAX_VALUE;
        while(current != null)
        {
            if((double)current.val == target)
            {
                return current.val;
            }
            double currentDiff = Math.abs(target - (double)current.val);
            if(currentDiff < minDiff)
            {
                min = current.val;
                minDiff = currentDiff;
            }
            else if(currentDiff == minDiff && current.val < min)
            {
                min = current.val;
            }
            if((double)current.val > target)
            {
                // move left
                current = current.left;
            }
            else
            {
                current = current.right;
            }
        }
        return min;
    }
}