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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
        {
            return null;
        }
        if(root.val == val)
        {
            return root;
        }
        if(root.val < val)
        {
            // search in right subtree
            return searchBST(root.right, val);
        }
        // if root is more than val then search in left
        return searchBST(root.left, val);
    }
}