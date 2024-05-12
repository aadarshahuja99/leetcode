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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructTree(new int[] {0}, preorder, Integer.MAX_VALUE);
    }
    private TreeNode constructTree(int[] currentIndex, int[] preorder, int maxValue)
    {
        if(currentIndex[0] == preorder.length || preorder[currentIndex[0]] > maxValue)
        {
            return null;
        }
        TreeNode current = new TreeNode(preorder[currentIndex[0]++]);
        current.left = constructTree(currentIndex, preorder, current.val);
        current.right = constructTree(currentIndex, preorder, maxValue);
        return current;
    }
}