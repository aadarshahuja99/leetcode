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
        int lastLevel = -1;
        int lastLevelNodes = 0;
        int expectedNullNodes = 0;
        bfsQueue.add(root);
        while(bfsQueue.size() > 0)
        {
            ArrayList<TreeNode> currentLevelNodes = new ArrayList<>();
            int size = bfsQueue.size();
            if(expectedNullNodes == size)
            {
                // System.out.println("exit 2");
                return true;
            }
            if(lastLevel >= 0 && lastLevelNodes != (int)Math.pow(2, lastLevel))
            {
                // System.out.println("exit 1 ");
                return false;
            }
            expectedNullNodes = 0;
            lastLevelNodes = 0;
            lastLevel++;
            for(int i=0; i<size; i++)
            {
                var top = bfsQueue.poll();
                if(currentLevelNodes.size() > 0 && currentLevelNodes.get(currentLevelNodes.size() - 1) == null && top != null)
                {
                    System.out.println("exit 3");
                    return false;
                }
                currentLevelNodes.add(top);
                if(top != null)
                {
                    lastLevelNodes++;
                    if(top.left == null)
                    {
                        expectedNullNodes++;
                    }
                    if(top.right == null)
                    {
                        expectedNullNodes++;
                    }
                    bfsQueue.add(top.left);
                    bfsQueue.add(top.right);
                }
            }
        }
        return true;
    }
}