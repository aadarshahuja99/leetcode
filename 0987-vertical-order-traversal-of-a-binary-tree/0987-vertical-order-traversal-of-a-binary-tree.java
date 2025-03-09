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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Element> q = new LinkedList<>();
        q.add(new Element( 0, root ));
        int level = 0;
        while(q.size() > 0)
        {
            int size = q.size();
            for(int i=0; i<size; i++)
            {
                var top = q.poll();
                if(!map.containsKey(top.line))
                {
                    map.put(top.line, new TreeMap<>());
                }
                if(!map.get(top.line).containsKey(level))
                {
                    map.get(top.line).put(level, new ArrayList<>());
                }
                map.get(top.line).get(level).add(top.node.val);
                if(top.node.left != null)
                {
                    q.add(new Element(top.line - 1, top.node.left));
                }
                if(top.node.right != null)
                {
                    q.add(new Element(top.line + 1, top.node.right));
                }
            }
            level++;
        }
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for(int line : map.keySet())
        {
            List<Integer> current = new ArrayList<>();
            for(int lev : map.get(line).keySet())
            {
                Collections.sort(map.get(line).get(lev));
                for(int val : map.get(line).get(lev))
                {
                    current.add(val);
                }
            }
            ans.add(current);
        }
        return ans;
    }
    class Element
    {
        int line;
        TreeNode node;
        Element(int l, TreeNode r)
        {
            line = l;
            node = r;
        }
    }
}