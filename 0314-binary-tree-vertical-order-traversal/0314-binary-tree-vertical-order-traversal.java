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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> store = new TreeMap<>();
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(root,0));
        int level = 0;
        while(q.size() > 0)
        {
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                var top = q.poll();
                if(!store.containsKey(top.c))
                {
                    store.put(top.c, new TreeMap<>());
                }
                if(!store.get(top.c).containsKey(level))
                {
                    store.get(top.c).put(level, new ArrayList<>());
                }
                store.get(top.c).get(level).add(top.node.val);
                if(top.node.left != null)
                {
                    q.add(new Element(top.node.left, top.c-1));
                }
                if(top.node.right != null)
                {
                    q.add(new Element(top.node.right, top.c+1));
                }
            }
            level++;
        }
        for(var cols : store.entrySet())
        {
            List<Integer> current = new ArrayList<>();
            for(var row : cols.getValue().entrySet())
            {
                current.addAll(row.getValue());
            }
            ans.add(current);
        }
        return ans;
    }
    class Element
    {
        TreeNode node;
        int c;
        Element(TreeNode n, int col)
        {
            node = n;
            c = col;
        }
    }
}