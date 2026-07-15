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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode current = root;
        List<Integer> ans = new ArrayList<>();
        while(current != null)
        {
            if(current.left == null)
            {
                ans.add(current.val);
                current = current.right;
            }
            else
            {
                // this is the right-most guy in the left subtree
                TreeNode inorderPredecessor = current.left;
                while(inorderPredecessor.right != null && inorderPredecessor.right != current)
                {
                    inorderPredecessor = inorderPredecessor.right;
                }
                // left sub-tree has not been visited to far, so we vist it
                if(inorderPredecessor.right == null)
                {
                    inorderPredecessor.right = current;
                    current = current.left;
                }
                else
                {
                    // left subtree has already been visited because we have a link from inorderPredecessor to the current node
                    inorderPredecessor.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }
        return ans;
    }

    public List<Integer> inorderUsingStack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode current = root;
        List<Integer> ans = new ArrayList<>();
        while(true)
        {
            if(current != null)
            {
                st.push(current);
                current = current.left;
            }
            else
            {
                if(st.isEmpty())
                {
                    return ans;
                }
                ans.add(st.peek().val);
                current = st.pop().right;
            }
        }
    }
}