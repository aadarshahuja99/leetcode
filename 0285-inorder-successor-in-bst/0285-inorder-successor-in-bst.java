/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        var it = new Iterator(root);
        TreeNode last = null;
        while(it.hasNext())
        {
            var current = it.getNext();
            if(last == p)
            {
                return current;
            }
            last = current;
        }
        return null;
    }
    class Iterator
    {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current;
        Iterator(TreeNode c)
        {
            current = c;
            push(current);
        }
        public TreeNode getNext()
        {
            var ans = st.pop();
            if(ans.right != null)
            {
                push(ans.right);
            }
            return ans;
        }
        public boolean hasNext()
        {
            return !st.isEmpty();
        }
        private void push(TreeNode c)
        {
            while(c != null)
            {
                st.push(c);
                c = c.left;
            }
        }
    }
}