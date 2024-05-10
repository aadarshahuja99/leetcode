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
    public int maxDepth(TreeNode root) {
        return depthUsingMorris(root);
    }
    private int dfs(TreeNode current)
    {
        if(current == null)
        {
            return 0;
        }
        int leftTreeLength = dfs(current.left);
        int rightTreeLength = dfs(current.right);
        return 1 + Math.max(leftTreeLength, rightTreeLength);
    }

    private int depthUsingMorris(TreeNode root)
    {
        TreeNode current = root;
        if(root == null)
        {
            return 0;
        }
        int currentDepth = 0;
        int ans = 0;
        while(current != null)
        {
            if(current.left != null)
            {
                int heightOfTheLeftSubtree = 1;
                TreeNode leftChild = current.left;
                while(leftChild.right != null && leftChild.right != current)
                {
                    leftChild = leftChild.right;
                    heightOfTheLeftSubtree++;
                }
                if(leftChild.right == current)
                {
                    leftChild.right = null;
                    currentDepth -= heightOfTheLeftSubtree + 1;
                    ans = Math.max(ans, currentDepth);
                    current = current.right;
                    currentDepth++;
                }
                else
                {
                    leftChild.right = current;
                    current = current.left;
                    currentDepth++;
                    ans = Math.max(ans, currentDepth);
                    // System.out.println(currentDepth+" = depth at "+current.val);
                }
            }
            else
            {
                current = current.right;
                ans = Math.max(ans, currentDepth);
                currentDepth++;
            }
        }
        return ans + 1;
    }
}