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
    int ans = 0;
    public int countNodes(TreeNode root) {
        // intuition: If the height (h) of left and right subtrees is same then right one is not completetly filled. Add (2^h) - 1 to ans and move to right subtree
        // else if height is not same then left is not completely filled, add (2^h) - 1 and move left
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == rightHeight)
        {
            ans += ((1<<leftHeight) - 1);
            dfs(root.right);
        }
        else
        {
            ans += ((1<<rightHeight) - 1);
            dfs(root.left);
        }
        ans++;
    }
    private int getHeight(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        return 1 + getHeight(root.left);
    }
}