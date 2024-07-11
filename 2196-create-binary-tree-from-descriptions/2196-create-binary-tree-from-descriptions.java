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
        HashMap<Integer,Integer> pMap = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        HashMap<Integer,Integer> left = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for(int[] desc : descriptions)
        {
            int p = desc[0];
            int c = desc[1];
            int d = desc[2];
            pMap.put(c, p);
            if(d == 1)
            {
                left.put(p, c);
            }
            else
            {
                right.put(p,c);
            }
            children.add(c);
        }
        int root = -1;
        for(int[] desc : descriptions)
        {
            if(!children.contains(desc[0]))
            {
                root = desc[0];
                break;
            }
        }
        return getTree(root, right, left);
    }
    private TreeNode getTree(int current, HashMap<Integer,Integer> right, HashMap<Integer,Integer> left)
    {
        TreeNode newNode = new TreeNode(current);
        if(right.containsKey(current))
        {
            newNode.right = getTree(right.get(current), right, left);
        }
        if(left.containsKey(current))
        {
            newNode.left = getTree(left.get(current), right, left);
        }
        return newNode;
    }
}