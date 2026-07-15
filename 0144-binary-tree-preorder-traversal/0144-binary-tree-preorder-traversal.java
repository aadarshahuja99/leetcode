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
    public List<Integer> preorderTraversal(TreeNode root)
    {
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
                    // since we are in pre-order, we put current to ans before visiting left sub-tree
                    ans.add(current.val);
                    inorderPredecessor.right = current;
                    current = current.left;
                }
                else
                {
                    // left subtree has already been visited because we have a link from inorderPredecessor to the current node
                    inorderPredecessor.right = null;
                    current = current.right;
                }
            }
        }
        return ans;
    }

    public List<Integer> preorderTraversalUsingStack(TreeNode root) {
        // Initialize a stack to track nodes
        Stack<TreeNode> st = new Stack<>();
        // Start from the root node
        TreeNode node = root;
        // Initialize a list to store
        // inorder traversal result
        List<Integer> preorder = new ArrayList<>();
        // Start an infinite
        // loop for traversal
        while (true) {
            // If the current node is not NULL
            if (node != null) {
                // Push the current
                // node to the stack
                st.push(node);
                preorder.add(node.val);
                // Move to the left child
                // of the current node
                node = node.left;
            } else {
                // If the stack is empty,
                // break the loop
                if (st.empty()) {
                    break;
                }
                // Retrieve a node from the stack
                node = st.pop().right;
            }
        }
        // Return the inorder
        // traversal result
        return preorder;
    }
}