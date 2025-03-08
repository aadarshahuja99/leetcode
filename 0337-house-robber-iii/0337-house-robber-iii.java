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
    public int rob(TreeNode root) {
        HashMap<TreeNode,HashMap<Integer,Integer>> cache = new HashMap<>();
        return getMaxMoney(root, 1, cache);
    }
    private int getMaxMoney(TreeNode root, int canRob, HashMap<TreeNode,HashMap<Integer,Integer>> cache)
    {
        if(root == null)
        {
            return 0;
        }
        if(cache.containsKey(root) && cache.get(root).containsKey(canRob))
        {
            return cache.get(root).get(canRob);
        }
        if(!cache.containsKey(root))
        {
            cache.put(root, new HashMap<>());
        }
        int dontRob = getMaxMoney(root.left, 1, cache) + getMaxMoney(root.right, 1, cache);
        if(canRob == 1)
        {
            int maxAns = Math.max(root.val + getMaxMoney(root.left, 0, cache) + getMaxMoney(root.right, 0, cache), dontRob);
            cache.get(root).put(canRob, maxAns);
            return maxAns;
        }
        cache.get(root).put(canRob, dontRob);
        return dontRob;
    }
}