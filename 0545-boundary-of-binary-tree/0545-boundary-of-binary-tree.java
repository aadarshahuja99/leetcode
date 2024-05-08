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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root.left == null && root.right == null)
        {
            ans.add(root.val);
            return ans;
        }
        if(root.left != null)
        {
            appendLeftBoundary(root, ans);
        }
        else
        {
            ans.add(root.val);
        }
        appendLeafNodesViaDFS(root, ans);
        if(root.right != null)
        {
            appendRightBoundary(root.right, ans);
        }
        return ans;
    }

    private void appendLeftBoundary(TreeNode root, List<Integer> boundary)
    {
        if(root.left == null && root.right == null)
        {
            return;
        }
        boundary.add(root.val);
        if(root.left != null)
        {
            appendLeftBoundary(root.left, boundary);
        }
        else
        {
            appendLeftBoundary(root.right, boundary);
        }
    }
    
    private void appendLeafNodesViaDFS(TreeNode root, List<Integer> boundary)
    {
        if(root.left == null && root.right == null)
        {
            boundary.add(root.val);
            return;
        }
        if(root.left != null)
        {
            appendLeafNodesViaDFS(root.left, boundary);
        }
        if(root.right != null)
        {
            appendLeafNodesViaDFS(root.right, boundary);
        }
    }

    private void appendRightBoundary(TreeNode root, List<Integer> boundary)
    {
        if(root.left == null && root.right == null)
        {
            return;
        }
        if(root.right != null)
        {
            appendRightBoundary(root.right, boundary);
        }
        else
        {
            appendRightBoundary(root.left, boundary);
        }
        boundary.add(root.val);
    }
}