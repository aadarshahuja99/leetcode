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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return areTreesEquivalent(root1, root2);
    }
    private boolean areTreesEquivalent(TreeNode root1, TreeNode root2)
    {
        if(root1 == null || root2 == null)
        {
            return root1 == null && root2 == null;
        }
        if(root1.val != root2.val)
        {
            return false;
        }
        boolean checkWithoutFlip = areTreesEquivalent(root1.left, root2.left) && areTreesEquivalent(root1.right, root2.right);
        if(checkWithoutFlip)
        {
            return true;
        }
        return areTreesEquivalent(root1.left, root2.right) && areTreesEquivalent(root1.right, root2.left);
    }
}