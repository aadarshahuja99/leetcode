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
        // using something similar to Morris traversal. The key idea is to connect the rightmost guy in the left subtree with the right child of the current node and then update the links
        if(root == null)
        {
            return;
        }
        TreeNode current = root;
        while(current != null)
        {
            if(current.left != null)
            {
                TreeNode leftSubtree = current.left;
                TreeNode iterator = leftSubtree;
                while(iterator.right != null)
                {
                    iterator = iterator.right;
                }
                iterator.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
    private TreeNode dfs(TreeNode root)
    {
        // more intuitive solution than striver's
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