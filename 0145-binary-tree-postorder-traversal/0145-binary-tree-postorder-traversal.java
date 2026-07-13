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
    public List<Integer> postorderTraversal(TreeNode root) {
        // iterative solution
        TreeNode current = root;
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true)
        {
            if(current != null)
            {
                st.add(current);
                current = current.left;
            }
            else
            {
                if(st.isEmpty())
                {
                    return ans;
                }
                TreeNode temp = st.peek().right;
                if(temp == null)
                {
                    // pop the leaf node and add it to traversal
                    temp = st.pop();
                    ans.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right)
                    {
                        temp = st.pop();
                        ans.add(temp.val);
                    }
                }
                else
                {
                    current = temp;
                }
            }
        }
    }
}