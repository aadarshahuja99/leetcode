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
    public int maxAncestorDiff(TreeNode root) {
        getAns(root.left, root.val, root.val);
        getAns(root.right, root.val, root.val);
        return ans;
    }
    private void getAns(TreeNode current, int max, int min)
    {
        if(current == null)
        {
            return;
        }
        // System.out.println(current.val+" "+max+" "+min);
        ans = Math.max(ans, Math.max(Math.abs(max - current.val), Math.abs(min - current.val)));
        getAns(current.left, Math.max(current.val, max), Math.min(min, current.val));
        getAns(current.right, Math.max(current.val, max), Math.min(min, current.val));
    }
}