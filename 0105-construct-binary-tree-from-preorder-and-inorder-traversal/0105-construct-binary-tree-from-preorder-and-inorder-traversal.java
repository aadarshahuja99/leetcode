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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<preorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return getAns(0, preorder.length-1, 0, map, preorder);
    }
    private TreeNode getAns(int start, int end, int inStart, HashMap<Integer,Integer> map, int[] pre)
    {
        if(start > end)
        {
            return null;
        }
        int val = pre[start];
        TreeNode current = new TreeNode(val);
        int idx = map.get(val);
        int leftLength = idx - inStart;
        current.left = getAns(start+1, start+leftLength, inStart, map, pre);
        current.right = getAns(start+leftLength+1, end, idx+1, map, pre);
        return current;
    }
}