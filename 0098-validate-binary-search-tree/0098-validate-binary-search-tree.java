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
        return dfs(root.left, root.val, Long.MIN_VALUE) && dfs(root.right, Long.MAX_VALUE, root.val);
    }
    private boolean dfs(TreeNode current, long maxPossibleValue, long minPossibleValue)
    {
        if(current == null)
        {
            return true;
        }
        if(current.val < maxPossibleValue && current.val > minPossibleValue)
        {
            boolean isLeftSubTreeValid = dfs(current.left, current.val, minPossibleValue);
            boolean isRightSubTreeValid = dfs(current.right, maxPossibleValue, current.val);
            return isLeftSubTreeValid && isRightSubTreeValid;
        }
        return false;
    }
}