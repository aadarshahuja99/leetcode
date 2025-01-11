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
    int ans = 0;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private Element dfs(TreeNode current)
    {
        if(current == null)
        {
            return new Element(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Element leftStatus = dfs(current.left);
        Element rightStatus = dfs(current.right);
        
        if(leftStatus.isValidBST && rightStatus.isValidBST && leftStatus.max < current.val && rightStatus.min > current.val)
        {
            int currentSize = 1 + leftStatus.size + rightStatus.size;
            
            ans = Math.max(ans, currentSize);
            
            return new Element(currentSize, true, Math.min(current.val, leftStatus.min), Math.max(current.val, rightStatus.max));
        }
        
        return new Element(0, false, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    class Element
    {
        int size;
        boolean isValidBST;
        int min;
        int max;
        Element(int s, boolean isValid, int mi, int ma)
        {
            size = s;
            isValidBST = isValid;
            min = mi;
            max = ma;
        }
    }
}