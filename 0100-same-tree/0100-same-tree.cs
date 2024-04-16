/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public bool IsSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }
        if(p == null || q == null)
        {
            return false;
        }
        List<int> pNodes = new();
        GetAllNodes(p, pNodes);
        List<int> qNodes = new();
        GetAllNodes(q, qNodes);
        int i = 0;
        while(i<pNodes.Count && pNodes[i] == qNodes[i])
        {
            i++;
        }
        if(i==pNodes.Count)
        {
            return true;
        }
        return false;
    }
    private void GetAllNodes(TreeNode root, List<int> result)
    {
        if(root == null)
        {
            result.Add(Int32.MinValue);
            return;
        }
        result.Add(root.val);
        GetAllNodes(root.left, result);
        GetAllNodes(root.right, result);
    }
}