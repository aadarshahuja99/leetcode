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
    public boolean isBalanced(TreeNode root) {
        return (check(root)).getValue();
    }
    private Pair<Integer,Boolean> check(TreeNode root)
    {
        if(root == null)
        {
            return new Pair<Integer,Boolean>(0, true);
        }

        var left = check(root.left);
        var right = check(root.right);

        int heightDifference = Math.abs(left.getKey() - right.getKey());
        return new Pair<Integer,Boolean>(1 + Math.max(left.getKey(), right.getKey()), (heightDifference <= 1) && left.getValue() && right.getValue());
    }
}