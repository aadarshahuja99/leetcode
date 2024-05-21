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
    public List<TreeNode> allPossibleFBT(int n) {
        if(n%2 == 0)
        {
            return new ArrayList<>();
        }
        return getAns(n);
    }
    private List<TreeNode> getAns(int rem)
    {
        List<TreeNode> ans = new ArrayList<>();
        if(rem == 0)
        {
            ans.add(null);
            return ans;
        }
        if(rem == 1)
        {
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i=1; i<rem; i+=2)
        {
            var leftTrees = getAns(i);
            var rightTrees = getAns(rem-i-1);
            for(TreeNode l : leftTrees)
            {
                for(TreeNode r : rightTrees)
                {
                    TreeNode current = new TreeNode(0);
                    current.left = l;
                    current.right = r;
                    ans.add(current);
                }
            }
        }
        return ans;
    }

}