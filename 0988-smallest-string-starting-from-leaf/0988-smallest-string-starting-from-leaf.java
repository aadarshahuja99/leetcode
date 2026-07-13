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
    String ans = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }
    private void dfs(TreeNode cur, StringBuilder sb)
    {
        if(cur == null)
        {
            return;
        }
        if(cur.left == null && cur.right == null)
        {
            sb.append((char)(cur.val + 'a'));
            String s = (new StringBuilder(sb)).reverse().toString();
            if(ans == null || ans.compareTo(s) > 0)
            {
                ans = s;
            }
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append((char)(cur.val + 'a'));
        dfs(cur.left, sb);
        dfs(cur.right, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}