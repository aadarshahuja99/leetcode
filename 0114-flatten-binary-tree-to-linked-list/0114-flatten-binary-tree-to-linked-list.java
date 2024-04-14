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
    public void flatten(TreeNode root) {
        // root left right, so in recursion we have to do right left root
        dfs(root);
    }
    private TreeNode dfs(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode rightMostFromLeft = dfs(root.left);
        TreeNode rightMostFromRight = dfs(root.right);
        if(root.left != null)
        {
            rightMostFromLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(rightMostFromRight != null)
        {
            return rightMostFromRight;
        }
        if(rightMostFromLeft != null)
        {
            return rightMostFromLeft;
        }
        return root;
    }
}