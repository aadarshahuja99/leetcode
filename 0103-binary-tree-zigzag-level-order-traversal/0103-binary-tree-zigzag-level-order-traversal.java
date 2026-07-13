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
            LinkedList<Integer> currentLevel = new LinkedList<>();
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                if(isReversed)
                {
                    currentLevel.addFirst(top.val);
                }
                else
                {
                    currentLevel.addLast(top.val);
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
            answer.add(new ArrayList<>(currentLevel));
        }
        return answer;
    }
}