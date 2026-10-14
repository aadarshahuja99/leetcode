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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if(root == null)
        {
            return new ArrayList<>(ans);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0)
        {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                currentLevel.add(top.val);
                if(top.left != null)
                {
                    queue.add(top.left);
                }
                if(top.right != null)
                {
                    queue.add(top.right);
                }
            }
            ans.addFirst(currentLevel);
        }
        return new ArrayList<>(ans);
    }
}