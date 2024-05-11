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
        return findLCA(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }
    private TreeNode findLCA(TreeNode current, int p, int q)
    {
        if(current == null)
        {
            return null;
        }
        if(current.val >= p && current.val <= q)
        {
            return current;
        }
        if(current.val < p)
        {
            return findLCA(current.right, p, q);
        }
        return findLCA(current.left, p, q);
    }
}