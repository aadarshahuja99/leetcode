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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode current = root;
        int visited = 0;
        while(current != null)
        {
            if(current.left != null)
            {
                TreeNode iterator = current.left;
                while(iterator.right != null && iterator.right != current)
                {
                    iterator = iterator.right;
                }
                if(iterator.right == null)
                {
                    iterator.right = current;
                    current = current.left;
                }
                else
                {
                    iterator.right = null;
                    // System.out.println("breaking the thread from "+iterator.val+" to "+current.val);
                    visited++;
                    if(visited == k)
                    {
                        return current.val;
                    }
                    current = current.right;
                }
            }
            else
            {
                visited++;
                if(visited == k)
                {
                    return current.val;
                }
                current = current.right;
            }
        }
        return -1;
    }
}