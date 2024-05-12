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
    public List<TreeNode> generateTrees(int n) {
        return getTrees(1, n);
    }
    private List<TreeNode> getTrees(int start, int end)
    {
        List<TreeNode> options = new ArrayList<>();
        if(start > end)
        {
            options.add(null);
            return options;
        }
        if(start == end)
        {
            options.add(new TreeNode(start));
            return options;
        }
        for(int i=start; i<=end; i++)
        {
            var leftOptions = getTrees(start, i-1);
            var rightOptions = getTrees(i+1, end);
            // System.out.println(leftOptions.size()+" "+rightOptions.size()+" "+i);
            for(TreeNode leftOption : leftOptions)
            {
                for(TreeNode rightOption : rightOptions)
                {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = leftOption;
                    currentNode.right = rightOption;
                    options.add(currentNode);
                }
            }
        }
        return options;
    }
}