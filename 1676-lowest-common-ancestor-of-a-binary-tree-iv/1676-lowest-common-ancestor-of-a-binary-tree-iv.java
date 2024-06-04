/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        int[] matching = new int[1];
        if(nodes.length == 1)
        {
            return nodes[0];
        }
        HashSet<Integer> set = new HashSet<>();
        for(TreeNode node : nodes)
        {
            set.add(node.val);
        }
        findLCA(root, set, 0);
        return ans;
    }
    private int findLCA(TreeNode current, HashSet<Integer> nodes, int matching)
    {
        if(current == null)
        {
            return 0;
        }
        int left = findLCA(current.left, nodes, matching);
        int right = findLCA(current.right, nodes, matching);
        matching += left + right;
        if(nodes.contains(current.val))
        {
            matching++;
        }
        if(matching == nodes.size() && ans == null)
        {
            ans = current;
        }
        return matching;
    }
}