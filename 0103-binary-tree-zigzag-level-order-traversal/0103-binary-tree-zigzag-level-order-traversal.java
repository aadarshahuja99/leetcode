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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<List<Integer>>();
        }
        ArrayList<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isReversed = false;
        while(queue.size() > 0)
        {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>(Collections.nCopies(size,0));
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                if(isReversed)
                {
                    currentLevel.set(size-1-i, top.val);
                }
                else
                {
                    currentLevel.set(i, top.val);
                }
                if(top.left != null)
                {
                    queue.add(top.left);
                }
                if(top.right != null)
                {
                    queue.add(top.right);
                }
            }
            isReversed = !isReversed;
            answer.add(currentLevel);
        }
        return answer;
    }
}