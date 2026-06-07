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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> hasParent = new HashSet<>();
        HashMap<Integer,int[]> childMap = new HashMap<>();
        for(int[] desc : descriptions)
        {
            int p = desc[0];
            int v = desc[1];
            int isLeft = desc[2];
            hasParent.add(v);
            if(childMap.containsKey(p))
            {
                int[] children = childMap.get(p);
                if(isLeft == 1)
                {
                    children[0] = v;
                }
                else
                {
                    children[1] = v;
                }
                childMap.put(p, children);
            }
            else
            {
                int[] children = {-1, -1};
                if(isLeft == 1)
                {
                    children[0] = v;
                }
                else
                {
                    children[1] = v;
                }
                childMap.put(p, children);
            }
        }
        int root = -1;
        for(int[] desc : descriptions)
        {
            if(!hasParent.contains(desc[0]))
            {
                root = desc[0];
            }
        }
        TreeNode rootNode = new TreeNode(root);
        dfs(rootNode, childMap);
        return rootNode;
    }
    private void dfs(TreeNode current, HashMap<Integer,int[]> childMap)
    {
        int val = current.val;
        if(!childMap.containsKey(val))
        {
            return;
        }
        if(childMap.get(val)[0] != -1)
        {
            TreeNode left = new TreeNode(childMap.get(val)[0]);
            dfs(left, childMap);
            current.left = left;
        }
        if(childMap.get(val)[1] != -1)
        {
            TreeNode right = new TreeNode(childMap.get(val)[1]);
            dfs(right, childMap);
            current.right = right;
        }
    }
}