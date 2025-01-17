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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        int swaps = 0;
        int level = 0;
        while(bfs.size() > 0)
        {
            int s = bfs.size();
            int[] vals = new int[s];
            for(int i=0; i<s; i++)
            {
                var top = bfs.poll();
                vals[i] = top.val;
                if(top.left != null)
                {
                    bfs.add(top.left);
                }
                if(top.right != null)
                {
                    bfs.add(top.right);
                }
            }
            // System.out.println(level);
            level++;
            int[] clone = vals.clone();
            Arrays.sort(clone);
            HashMap<Integer,Integer> indexMap = new HashMap<>();
            for(int i=0; i<s; i++)
            {
                indexMap.put(clone[i], i);
            }
            for(int i=0; i<s; i++)
            {
                vals[i] = indexMap.get(vals[i]);
                // System.out.println(vals[i]+", val for "+i);
            }
            for(int i=0; i<s; i++)
            {
                for(;vals[i] != i; ++swaps)
                {
                    swap(vals[i], vals[vals[i]], vals);
                }
            }
        }
        return swaps;
    }
    private void swap(int i, int j, int[] vals)
    {
        int temp = vals[i];
        vals[i] = vals[j];
        vals[j] = temp;
    }
}