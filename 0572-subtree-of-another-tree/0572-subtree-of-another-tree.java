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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return checkForSubTree(root, subRoot);
    }
    private boolean checkForSubTree(TreeNode root, TreeNode subRoot)
    {
        if(root == null || subRoot == null)
        {
            return root == null && subRoot == null;
        }
        if(checkIfTreesMatch(root, subRoot))
        {
            return true;
        }
        return checkForSubTree(root.left, subRoot) || checkForSubTree(root.right, subRoot);
    }
    private boolean checkIfTreesMatch(TreeNode root, TreeNode subRoot)
    {
        if(root == null || subRoot == null)
        {
            return root == null && subRoot == null;
        }
        return root.val == subRoot.val && checkIfTreesMatch(root.left, subRoot.left) && checkIfTreesMatch(root.right, subRoot.right);
    }
}