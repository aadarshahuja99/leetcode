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
    public int[] treeQueries(TreeNode root, int[] queries) {
        HashMap<Integer,int[]> levelInfo = new HashMap<>();
        HashMap<Integer,Integer> nodeToLevelMap = new HashMap<>();
        HashMap<Integer, Integer> heightMap = new HashMap<>();
        int[] ans = new int[queries.length];
        computeMaxPathLengthsPassingThroughNodes(root, 0, levelInfo, nodeToLevelMap, heightMap);
        int idx = 0;
        for(int q : queries)
        {
            int level = nodeToLevelMap.get(q);
            int height = heightMap.get(q);
            if(levelInfo.get(level)[1] == 0)
            {
                ans[idx] = level - 1;
            }
            else if(height == levelInfo.get(level)[0])
            {
                ans[idx] = levelInfo.get(level)[1] + level - 1;
            }
            else
            {
                ans[idx] = levelInfo.get(level)[0] + level - 1;
            }
            idx++;
        }
        return ans;
    }
    private int computeMaxPathLengthsPassingThroughNodes(TreeNode root, int depth, HashMap<Integer,int[]> levelInfo, HashMap<Integer,Integer> nodeToLevelMap, HashMap<Integer,Integer> heightMap)
    {
        if(root == null)
        {
            return 0;
        }
        nodeToLevelMap.put(root.val, depth);
        int left = computeMaxPathLengthsPassingThroughNodes(root.left, depth+1, levelInfo, nodeToLevelMap, heightMap);
        int right = computeMaxPathLengthsPassingThroughNodes(root.right, depth+1, levelInfo, nodeToLevelMap, heightMap);
        int maxHeight = 1 + Math.max(left, right);
        if(!levelInfo.containsKey(depth))
        {
            levelInfo.put(depth, new int[] { maxHeight, 0 });
        }
        else
        {
            if(levelInfo.get(depth)[0] <= maxHeight)
            {
                levelInfo.get(depth)[1] = levelInfo.get(depth)[0];
                levelInfo.get(depth)[0] = maxHeight;
            }
            else if(levelInfo.get(depth)[1] <= maxHeight)
            {
                levelInfo.get(depth)[1] = maxHeight;
            }
        }
        heightMap.put(root.val, maxHeight);
        return maxHeight;
    }
    
}