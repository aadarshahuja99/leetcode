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
        if(root == null)
        {
            return true;
        }
        return checkForBalancedTree(root);
    }
    private Pair<Integer,Boolean> check(TreeNode root)
    {
        if(root == null)
        {
            return new Pair<Integer,Boolean>(0, true);
        }

        var left = check(root.left);
        var right = check(root.right);

        int heightDifference = Math.abs(left.getKey() - right.getKey());
        return new Pair<Integer,Boolean>(1 + Math.max(left.getKey(), right.getKey()), (heightDifference <= 1) && left.getValue() && right.getValue());
    }

    private boolean checkForBalancedTree(TreeNode root)
    {
        TreeNode current = root;
        HashSet<TreeNode> visited = new HashSet<>();
        HashMap<TreeNode,Integer> heights = new HashMap<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);

        while(!stack.isEmpty())
        {
            visited.add(stack.peek());
            heights.put(current, 1);
            if(stack.peek().left != null && !visited.contains(stack.peek().left))
            {
                heights.put(stack.peek().left,1);
                stack.push(stack.peek().left);
                continue;
            }
            if(stack.peek().right != null && !visited.contains(stack.peek().right))
            {
                heights.put(stack.peek().right,1);
                stack.push(stack.peek().right);
                continue;
            }
            int leftHeight = 0;
            int rightHeight = 0;
            if(stack.peek().left != null)
            {
                leftHeight = heights.get(stack.peek().left);
            }
            if(stack.peek().right != null)
            {
                rightHeight = heights.get(stack.peek().right);
            }
            // System.out.println(leftHeight+" "+rightHeight+" "+stack.peek().val);
            if(Math.abs(leftHeight - rightHeight) > 1)
            {
                return false;
            }
            heights.put(stack.peek(), heights.get(stack.peek()) + Math.max(leftHeight, rightHeight));
            stack.pop();
        }
        return true;
    }
}