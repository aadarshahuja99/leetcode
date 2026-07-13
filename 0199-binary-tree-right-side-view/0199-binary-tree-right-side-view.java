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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                TreeNode front = q.poll();
                if(i == s-1)
                {
                    ans.add(front.val);
                }
                if(front.left != null)
                {
                    q.add(front.left);
                }
                if(front.right != null)
                {
                    q.add(front.right);
                }
            }
        }
        return ans;
    }
}