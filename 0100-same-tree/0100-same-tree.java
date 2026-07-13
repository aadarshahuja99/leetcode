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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // return dfs(p, q);
        return iterative(p, q);
    }
    private boolean dfs(TreeNode c1, TreeNode c2)
    {
        if(c1 == null || c2 == null)
        {
            return c1 == c2;
        }
        return c1.val == c2.val && dfs(c1.left, c2.left) && dfs(c1.right, c2.right);
    }
    private boolean iterative(TreeNode c1, TreeNode c2)
    {
        TreeNode current1 = c1;
        TreeNode current2 = c2;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        while(true)
        {
            if(current1 == null || current2 == null)
            {
                if(current1 != current2)
                {
                    return false;
                }
                if(s1.isEmpty() || s2.isEmpty())
                {
                    return s1.isEmpty() && s2.isEmpty();
                }
                current1 = s1.pop().right;
                current2 = s2.pop().right;
            }
            else
            {
                if(current1.val != current2.val)
                {
                    return false;
                }
                s1.push(current1);
                s2.push(current2);
                current1 = current1.left;
                current2 = current2.left;
            }
        }
    }
}