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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Element> q = new LinkedList<>();
        int ans = 0;
        q.add(new Element(root, 0));
        while(q.size() > 0)
        {
            int s = q.size();
            int first = 0;
            int last = 0;
            for(int i=0; i<s; i++)
            {
                var top = q.poll();
                if(i == 0)
                {
                    first = top.index;
                }
                last = top.index;
                // we are re-basing the values to 0 based indexes so that we can avoid int/long overflow in case of skewed binary tree (2^10^5 can happen if not rebased)
                int current = top.index - first;
                if(top.node.left != null)
                {
                    q.add(new Element(top.node.left, 2*current+1));
                }
                if(top.node.right != null)
                {
                    q.add(new Element(top.node.right, 2*current+2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
    class Element
    {
        int index;
        TreeNode node;
        public Element(TreeNode r, int v)
        {
            node = r;
            index = v;
        }
    }
}