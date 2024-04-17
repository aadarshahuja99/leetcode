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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
        {
            return 0;
        }
        int[] ans = new int[1];
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0l, 1);
        findPathSum(root, targetSum, 0l, map, ans);
        return ans[0];
    }
    private void findPathSum(TreeNode root, int target, long sumSoFar, HashMap<Long,Integer> map, int[] ans)
    {
        if(root == null)
        {
            return;
        }
        sumSoFar += root.val;
        if(map.containsKey(sumSoFar - target))
        {
            ans[0] += map.get(sumSoFar - target);
        }
        map.put(sumSoFar, map.getOrDefault(sumSoFar, 0) + 1);
        findPathSum(root.left, target, sumSoFar, map, ans);
        findPathSum(root.right, target, sumSoFar, map, ans);
        map.put(sumSoFar, map.get(sumSoFar) - 1);
    }
}