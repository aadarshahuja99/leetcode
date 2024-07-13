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
    public List<Integer> preorderTraversal(TreeNode root) {
        // iterative
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        List<Integer> ans = new ArrayList<>();
        while(true)
        {
            if(current != null)
            {
                ans.add(current.val);
                st.push(current);
                current = current.left;
            }
            else
            {
                if(st.size() == 0)
                {
                    return ans;
                }
                var top = st.pop();
                current = top.right;
            }
        }
    }
}