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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
        {
            return null;
        }
        if(root.val > key)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            // root val is the key
            if(root.left == null && root.right == null)
            {
                // key node is a leaf node
                return null;
            }
            if(root.left == null)
            {
                // if the key node has only one child then replace the key node with the right child
                return root.right;
            }
            if(root.right == null)
            {
                // same as previous if
                return root.left;
            }
            // if key node is an internal node, then find the inorderPredecessor
            TreeNode inorderPredecessor = root.left;
            while(inorderPredecessor.right != null)
            {
                inorderPredecessor = inorderPredecessor.right;
            }
            root.val = inorderPredecessor.val;
            // same as removing the leaf node (inorderPredecessor will always be a leaf node)
            root.left = deleteNode(root.left, inorderPredecessor.val);
        }
        return root;
    }
}