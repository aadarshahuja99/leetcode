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
    public TreeNode sortedArrayToBST(int[] nums) {
        // choose the middle element
        return constructTree(0, nums.length-1, nums);
    }
    private TreeNode constructTree(int low, int high, int[] nums)
    {
        if(low > high)
        {
            return null;
        }
        if(low == high)
        {
            return new TreeNode(nums[low]);
        }
        int mid = low + (high - low)/2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructTree(low, mid-1, nums);
        current.right = constructTree(mid+1, high, nums);
        return current;
    }
}