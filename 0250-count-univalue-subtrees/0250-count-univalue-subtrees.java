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
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        countSingleValueTrees(root, count);
        return count[0];
    }
    public boolean countSingleValueTrees(TreeNode current, int[] count)
    {
        if(current == null)
        {
            return true;
        }
        
        boolean rightTreeStatus = countSingleValueTrees(current.right, count);
        boolean leftTreeStatus = countSingleValueTrees(current.left, count);
        leftTreeStatus = current.left == null || (leftTreeStatus && current.val == current.left.val);
        rightTreeStatus = current.right == null || (rightTreeStatus && current.val == current.right.val);   
        
        if(leftTreeStatus && rightTreeStatus)
        {
            count[0] += 1;
        }
        
        return leftTreeStatus && rightTreeStatus;
    }
}