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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(0, n-1, n-1, postorder, map);
    }
    private TreeNode helper(int st, int end, int inEnd, int[] post, HashMap<Integer,Integer> map)
    {
        if(st > end)
        {
            return null;
        }
        TreeNode curr = new TreeNode(post[end]);
        int idx = map.get(post[end]);
        int rightSubTreeLength = inEnd - idx;
        curr.left = helper(st, end-rightSubTreeLength-1, idx-1, post, map);
        curr.right = helper(end-rightSubTreeLength, end-1, inEnd, post, map);
        return curr;
    }
}