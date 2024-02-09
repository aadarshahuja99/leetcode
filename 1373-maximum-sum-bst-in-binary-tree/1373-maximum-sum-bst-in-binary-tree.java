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
    int ans = 0;
    // an advanced version of largest BST in a BT question
    public int maxSumBST(TreeNode root) {
        getAns(root);
        return ans;
    }
    private DFSElement getAns(TreeNode root)
    {
        if(root == null)
        {
            return new DFSElement(0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
        }
        var left = getAns(root.left);
        var right = getAns(root.right);
        if(left.isBST && right.isBST && root.val > left.max && root.val < right.min)
        {
            ans = Math.max(ans,root.val+left.sum+right.sum);
            return new DFSElement(root.val+left.sum+right.sum,Math.max(right.max,root.val),
            Math.min(root.val,left.min),true);
        }
        return new DFSElement(0,right.max,left.min,false);
    }
    class DFSElement
    {
        public int sum;
        public int max;
        public int min;
        public boolean isBST;
        public DFSElement(int s, int ma, int mi, boolean isbst)
        {
            sum = s;
            max = ma;
            min = mi;
            isBST = isbst;
        }
    }
}