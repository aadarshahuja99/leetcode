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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // always insert at the correct possible leaf
        TreeNode newNode = new TreeNode(val);
        if(root == null)
        {
            return newNode;
        }
        if(root.val > val)
        {
            // search left
            root.left = insertIntoBST(root.left, val);
        }
        else
        {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}