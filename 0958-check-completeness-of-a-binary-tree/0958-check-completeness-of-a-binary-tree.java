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
    public boolean isCompleteTree(TreeNode root) {
        if(root.right == null && root.left == null)
        {
            return true;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        boolean wasLastLevelIncomplete = false;
        while(bfsQueue.size() > 0)
        {
            boolean hasNullBeenSeen = false;
            int size = bfsQueue.size();
            for(int i=0; i<size; i++)
            {
                var top = bfsQueue.poll();
                if(top == null)
                {
                    if(hasNullBeenSeen)
                    {
                        continue;
                    }
                    else
                    {
                        hasNullBeenSeen = true;
                    }
                }
                else
                {
                    if(hasNullBeenSeen || wasLastLevelIncomplete)
                    {
                        return false;
                    }
                    bfsQueue.add(top.left);
                    bfsQueue.add(top.right);
                }
            }
            wasLastLevelIncomplete = hasNullBeenSeen;
        }
        return true;
    }
}