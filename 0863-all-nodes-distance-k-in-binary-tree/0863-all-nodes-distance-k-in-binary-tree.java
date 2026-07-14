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
    HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        int d = 0;
        dfs(root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> vis = new HashSet<>();
        vis.add(target);
        while(q.size() > 0 || d <= k)
        {
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                var top = q.poll();
                if(d == k)
                {
                    ans.add(top.val);
                }
                if(top.left != null && !vis.contains(top.left))
                {
                    vis.add(top.left);
                    q.add(top.left);
                }
                if(top.right != null && !vis.contains(top.right))
                {
                    vis.add(top.right);
                    q.add(top.right);
                }
                if(parentMap.get(top) != null && !vis.contains(parentMap.get(top)))
                {
                    vis.add(parentMap.get(top));
                    q.add(parentMap.get(top));
                }
            }
            d++;
        }
        return ans;
    }
    private void dfs(TreeNode current)
    {
        if(current.left != null)
        {
            dfs(current.left);
            parentMap.put(current.left, current);
        }
        if(current.right != null)
        {
            dfs(current.right);
            parentMap.put(current.right, current);
        }
    }
}