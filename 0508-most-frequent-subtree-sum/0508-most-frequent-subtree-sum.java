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
    int max = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        int ret = getAns(root);
        return ans.stream()
                  .mapToInt(Integer::intValue) // Or: i -> i
                  .toArray();
    }
    private int getAns(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftSum = getAns(root.left);
        int rightSum = getAns(root.right);
        int current = root.val + leftSum + rightSum;
        map.put(current, map.getOrDefault(current,0) + 1);
        if(map.get(current) > max)
        {
            max = map.get(current);
            ans = new ArrayList<>();
            ans.add(current);
        }
        else if(map.get(current) == max)
        {
            ans.add(current);
        }
        return current;
    }
}