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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean rootStatus = checkIfSubtreeCanBeDeleted(root, root.val, limit);
        if(rootStatus)
        {
            return null;
        }
        return root;
    }
    private boolean checkIfSubtreeCanBeDeleted(TreeNode root, int currentSum, int limit)
    {
        if(root.left == null && root.right == null)
        {
            if(currentSum < limit)
            {
                return true;
            }
            return false;
        }
        boolean leftStatus = true;
        if(root.left != null)
        {
            leftStatus = checkIfSubtreeCanBeDeleted(root.left, currentSum + root.left.val, limit);
        }
        boolean rightStatus = true;
        if(root.right != null)
        {
            rightStatus = checkIfSubtreeCanBeDeleted(root.right, currentSum + root.right.val, limit);
        }
        if(!leftStatus && rightStatus)
        {
            root.right = null;
        }
        else if(leftStatus && !rightStatus)
        {
            root.left = null;
        }
        else if(leftStatus && rightStatus)
        {
            return true;
        }
        return false;
    }
}