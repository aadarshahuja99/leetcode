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
    public boolean isBalanced(TreeNode root) {
        return checkForBalancedTree(root);
    }
    private int check(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftHeight = check(root.left);
        int rightHeight = check(root.right);
        if(leftHeight == -1 || rightHeight == -1)
        {
            return -1;
        }
        if(Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
    private boolean checkForBalancedTree(TreeNode root)
    {
        TreeNode current = root;
        HashMap<TreeNode,Integer> heights = new HashMap<>();
        heights.put(null, 0);
        Stack<TreeNode> stack = new Stack<>();
        while(true)
        {
            if(current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else
            {
                if(stack.isEmpty())
                {
                    break;
                }
                var top = stack.peek().right;
                if(top == null)
                {
                    // both left and rigth subtrees have been traversed
                    if(!checkIfCurrentNodeIsValid(stack.peek(), heights))
                    {
                        return false;
                    }
                    top = stack.pop();
                    while(!stack.isEmpty() && top == stack.peek().right)
                    {
                        if(!checkIfCurrentNodeIsValid(stack.peek(), heights))
                        {
                            return false;
                        }
                        top = stack.pop();
                    }
                }
                else
                {
                    current = top;
                }
            }
        }
        return true;
    }
    private boolean checkIfCurrentNodeIsValid(TreeNode current, HashMap<TreeNode,Integer> heights)
    {
        int left = heights.get(current.left);
        int right = heights.get(current.right);
        if(Math.abs(left - right) > 1)
        {
            return false;
        }
        heights.put(current, 1 + Math.max(left, right));
        return true;
    }
}