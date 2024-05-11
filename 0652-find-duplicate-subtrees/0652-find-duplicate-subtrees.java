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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        dfs(root, new HashMap<String,Integer>(), new HashMap<Integer,Integer>(), ans);
        return ans;
    }
    private int dfs(TreeNode current, HashMap<String,Integer> stringToIdMap, HashMap<Integer,Integer> counts, List<TreeNode> result)
    {
        if(current == null)
        {
            return 0;
        }
        String encodedTree = dfs(current.left, stringToIdMap, counts, result) +  "," + current.val
        + "," + dfs(current.right, stringToIdMap, counts, result);

        int id = 0;
        if(stringToIdMap.containsKey(encodedTree))
        {
            id = stringToIdMap.get(encodedTree);
        }
        else
        {
            id = stringToIdMap.size() + 1;
            stringToIdMap.put(encodedTree, id);
        }
        counts.put(id, counts.getOrDefault(id, 0) + 1);
        if(counts.get(id) == 2)
        {
            result.add(current);
        }
        // System.out.println("at "+current.val+" encoded: "+encodedTree+" id: "+id);
        return id;
    }
}