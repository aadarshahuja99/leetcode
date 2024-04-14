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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return trimInvalidNodes(root, null, false, low, high);
    }
    private TreeNode trimInvalidNodes(TreeNode root, TreeNode parent, boolean isLeft, int low, int high)
    {
        if(root == null)
        {
            return root;
        }
        if(root.val < low)
        {
            if(parent == null)
            {
                TreeNode rightChild = root.right;
                root.right = null;
                return trimInvalidNodes(rightChild, null, false, low, high);
            }
            if(isLeft)
            {
                parent.left = root.right;
                root.right = null;
                return trimInvalidNodes(parent.left, parent, true, low, high);
            }
            parent.right = root.right;
            root.right = null;
            return trimInvalidNodes(parent.right, parent, false, low, high);
        }
        if(root.val > high)
        {
            if(parent == null)
            {
                TreeNode leftChild = root.left;
                root.left = null;
                return trimInvalidNodes(leftChild, null, false, low, high);
            }
            if(isLeft)
            {
                parent.left = root.left;
                root.left = null;
                return trimInvalidNodes(parent.left, parent, true, low, high);
            }
            parent.right = root.left;
            root.left = null;
            return trimInvalidNodes(parent.right, parent, false, low, high);
        }
        root.left = trimInvalidNodes(root.left, root, true, low, high);
        root.right = trimInvalidNodes(root.right, root, false, low, high);
        return root;
    }
}