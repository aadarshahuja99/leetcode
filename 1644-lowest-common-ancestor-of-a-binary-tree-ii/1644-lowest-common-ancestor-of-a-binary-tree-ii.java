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
    private int discoveredCount = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode tentativeAns = getLCA(root, p, q);
        if(discoveredCount == 2)
        {
            return tentativeAns;
        }
        return null;
    }
    private TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode left = getLCA(root.left, p, q);
        TreeNode right = getLCA(root.right, p, q);
        if(root == p || root == q)
        {
            discoveredCount++;
            return root;
        }
        if(left != null && right != null)
        {
            return root;
        }
        if(left != null)
        {
            return left;
        }
        return right;
    }
}