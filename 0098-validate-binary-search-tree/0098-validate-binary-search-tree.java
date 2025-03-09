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
    public boolean isValidBST(TreeNode root) {
        return getAns(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean getAns(TreeNode c, long max, long min)
    {
        if(c == null)
        {
            return true;
        }
        if(c.val >= max || c.val <= min)
        {
            return false;
        }
        boolean leftStatus = getAns(c.left, c.val, min);
        boolean rightStatus = getAns(c.right, max, c.val);
        return leftStatus && rightStatus;
    }
}