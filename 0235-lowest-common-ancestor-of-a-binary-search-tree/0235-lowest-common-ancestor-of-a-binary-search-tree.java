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
    private TreeNode findLCA(TreeNode current, int minVal, int maxVal)
    {
        if(current == null)
        {
            return null;
        }
        if(current.val >= minVal && current.val <= maxVal)
        {
            return current;
        }
        if(current.val < minVal)
        {
            return findLCA(current.right, minVal, maxVal);
        }
        return findLCA(current.left, minVal, maxVal);
    }
}