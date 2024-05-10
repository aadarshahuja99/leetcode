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
    public TreeNode correctBinaryTree(TreeNode root) {
        correctTree(root, null, false, new HashSet<Integer>());
        return root;
    }
    private void correctTree(TreeNode root, TreeNode parent, boolean isLeftChild, HashSet<Integer> visited)
    {
        if(root == null)
        {
            return;
        }
        if(root.right != null && visited.contains(root.right.val))
        {
            if(isLeftChild)
            {
                parent.left = null;
            }
            else
            {
                parent.right = null;
            }
            root.right = null;
            return;
        }
        visited.add(root.val);
        correctTree(root.right, root, false, visited);
        correctTree(root.left, root, true, visited);
    }
}