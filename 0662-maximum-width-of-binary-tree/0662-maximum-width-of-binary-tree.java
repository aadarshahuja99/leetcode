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
            int levelMin = -1;
            int levelMax = -1;
            for(int i=0; i<s; i++)
            {
                var top = q.poll();
                if(levelMin == -1)
                {
                    levelMin = top.val;
                }
                int current = top.val - levelMin;
                levelMax = Math.max(levelMax, top.val);
                if(top.node.left != null)
                {
                    q.add(new Element(top.node.left, 2*current+1));
                }
                if(top.node.right != null)
                {
                    q.add(new Element(top.node.right, 2*current+2));
                }
            }
            ans = Math.max(ans, levelMax - levelMin + 1);
        }
        return ans;
    }
    class Element
    {
        int val;
        TreeNode node;
        public Element(TreeNode r, int v)
        {
            node = r;
            val = v;
        }
    }
}