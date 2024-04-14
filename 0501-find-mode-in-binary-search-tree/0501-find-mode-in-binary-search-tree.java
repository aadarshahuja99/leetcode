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
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;
        int maxCount = 0;
        int lastElement = -1;
        int lastElementCount = 0;
        HashSet<Integer> modes = new HashSet<>();
        while(true)
        {
            if(currentNode != null)
            {
                // System.out.println("pushed "+currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else
            {
                if(stack.size() == 0)
                {
                    break;
                }
                TreeNode top = stack.pop();
                if(top.val == lastElement)
                {
                    lastElementCount++;
                }
                else
                {
                    lastElementCount = 1;
                    lastElement = top.val;
                }
                // System.out.println(lastElementCount+" "+maxCount+" "+lastElement);
                if(lastElementCount > maxCount)
                {
                    maxCount = lastElementCount;
                    modes.clear();
                }
                if(lastElementCount == maxCount)
                {
                    modes.add(lastElement);
                }
                if(top.right != null)
                {
                    currentNode = top.right;
                }
            }
        }
        int idx = 0;
        int[] modesArray = new int[modes.size()];
        for(int mode : modes)
        {
            modesArray[idx] = mode;
            idx++;
        }
        return modesArray;
    }
}