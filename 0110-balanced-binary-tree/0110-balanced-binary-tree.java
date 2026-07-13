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
        int ans = check(root);
        return ans != -1;
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
        while(!stack.isEmpty() || current != null)
        {
            if(current != null)
            {
                stack.push(current);
                current = current.left;
            }
            else
            {
                var top = stack.peek().right;
                if(top == null)
                {
                    // both left and rigth subtrees have been traversed
                    int leftHeight = heights.get(stack.peek().left);
                    int rightHeight = heights.get(stack.peek().right);
                    if(Math.abs(leftHeight - rightHeight) > 1)
                    {
                        return false;
                    }
                    heights.put(stack.peek(), 1 + Math.max(leftHeight, rightHeight));
                    top = stack.pop();
                    while(!stack.isEmpty() && top == stack.peek().right)
                    {
                        int left = heights.get(stack.peek().left);
                        int right = heights.get(stack.peek().right);
                        if(Math.abs(left - right) > 1)
                        {
                            return false;
                        }
                        heights.put(stack.peek(), 1 + Math.max(left, right));
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
}