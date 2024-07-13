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
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }
    private boolean check(TreeNode root1, TreeNode root2)
    {
        if(root1 == null || root2 == null)
        {
            return root1 == null && root2 == null;
        }
        if(root1.val != root2.val)
        {
            return false;
        }
        boolean leftCheck = check(root1.left, root2.right);
        boolean rightCheck = check(root1.right, root2.left);
        return leftCheck && rightCheck;
    }
}