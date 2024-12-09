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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int[] ans = new int[1];
        findLongestUniValuePath(root, ans);
        return ans[0];
    }
    private int findLongestUniValuePath(TreeNode current, int[] ans)
    {

        if(current.left == null && current.right == null)
        {
            return 1;
        }
        
        int leftLength = 0;
        int rightLength = 0;

        if(current.left != null)
        {
            leftLength = findLongestUniValuePath(current.left, ans);
            if(current.left.val != current.val)
            {
                leftLength = 0;
            }
        }
        if(current.right != null)
        {
            rightLength = findLongestUniValuePath(current.right, ans);
            if(current.right.val != current.val)
            {
                rightLength = 0;
            }
        }
        // System.out.println(leftLength+" "+rightLength+" for "+current.val);
        ans[0] = Math.max(ans[0], leftLength+rightLength);
        return 1 + Math.max(leftLength, rightLength);
    }
}