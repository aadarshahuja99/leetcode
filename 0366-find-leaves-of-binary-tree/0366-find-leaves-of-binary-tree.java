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
    public List<List<Integer>> findLeaves(TreeNode root) {
        HashMap<TreeNode,Integer> heightMap = new HashMap<>();
        int maxHeight = getHeight(root, heightMap);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<=maxHeight; i++)
        {
            ans.add(new ArrayList<>());
        }
        for(Map.Entry<TreeNode,Integer> nodeToHeight : heightMap.entrySet())
        {
            // System.out.println(nodeToHeight.getKey().val+" "+nodeToHeight.getValue());
            ans.get(nodeToHeight.getValue()).add(nodeToHeight.getKey().val);
        }
        return ans;
    }
    private int getHeight(TreeNode root, HashMap<TreeNode,Integer> heightMap)
    {
        if(root.left == null && root.right == null)
        {
            heightMap.put(root, 0);    
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left != null)
        {
            left = 1 + getHeight(root.left, heightMap);
        }
        if(root.right != null)
        {
            right = 1 + getHeight(root.right, heightMap);
        }
        int currentHeight = Math.max(left, right);
        heightMap.put(root, currentHeight);
        return currentHeight;
    }
}