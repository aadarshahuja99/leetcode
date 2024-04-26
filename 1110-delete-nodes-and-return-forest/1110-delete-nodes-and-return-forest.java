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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<TreeNode> roots = new HashSet<>();
        roots.add(root);
        for(int node : to_delete)
        {
            for(TreeNode currentRoot : roots)
            {
                if(deleteNode(currentRoot, null, false, roots, node))
                {
                    break;
                }
            }
        }
        List<TreeNode> ans = new ArrayList<>();
        for(TreeNode current : roots)
        {
            ans.add(current);
        }
        return ans;
    }
    private boolean deleteNode(TreeNode root, TreeNode parent, boolean isLeftChild, HashSet<TreeNode> roots, int value)
    {
        if(root == null)
        {
            return false;
        }
        if(root.val == value)
        {
            if(parent != null)
            {
                if(isLeftChild)
                {
                    parent.left = null;
                }
                else
                {
                    parent.right = null;
                }
            }
            else
            {
                roots.remove(root);
            }
            if(root.left != null || root.right != null)
            {
                if(root.left != null)
                {
                    roots.add(root.left);
                }
                if(root.right != null)
                {
                    roots.add(root.right);
                }
            }
            return true;
        }
        return deleteNode(root.left, root, true, roots, value) || deleteNode(root.right, root, false, roots, value);
    }
}