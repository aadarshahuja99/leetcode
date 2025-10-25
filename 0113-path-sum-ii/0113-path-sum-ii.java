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
    ArrayList<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<Integer>());
        return ans;
    }
    private void dfs(TreeNode current, int rem, ArrayList<Integer> list)
    {
        if(current == null)
        {
            return;
        }
        if(current.left == null && current.right == null)
        {
            if(rem == current.val)
            {
                list.add(current.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(current.val);
        dfs(current.left, rem - current.val, list);
        dfs(current.right, rem - current.val, list);
        list.remove(list.size()-1);
        return;
    }
}