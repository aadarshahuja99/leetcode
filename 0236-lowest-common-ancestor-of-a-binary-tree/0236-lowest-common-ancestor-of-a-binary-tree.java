/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    private TreeNode dfs(TreeNode current, TreeNode p, TreeNode q)
    {
        if(current == null)
        {
            return null;
        }
        if(current == p || current == q)
        {
            return current;
        }
        var left = dfs(current.left, p, q);
        var right = dfs(current.right, p, q);
        if(left != null && right != null)
        {
            return current;
        }
        if(left != null)
        {
            return left;
        }
        if(right != null)
        {
            return right;
        }
        return null;
    }
}