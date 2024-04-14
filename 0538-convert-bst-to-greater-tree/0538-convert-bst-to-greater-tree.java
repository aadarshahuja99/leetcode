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
    int lastComputedSum = 0;
    public TreeNode convertBST(TreeNode root) {
        // reverse inorder using recursion
        convert(root);
        return root;
    }
    private void convert(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        convert(root.right);
        root.val += lastComputedSum;
        lastComputedSum = root.val;
        convert(root.left);
        return;
    }
}