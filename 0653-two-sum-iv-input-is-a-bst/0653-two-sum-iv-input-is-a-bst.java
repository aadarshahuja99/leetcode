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
    public boolean findTarget(TreeNode root, int k) {
        // extended version of BST iterator
        BSTIterator increasing = new BSTIterator(root,true);
        BSTIterator decreasing = new BSTIterator(root,false);
        int left = increasing.getNext();
        int right = decreasing.getNext();
        while(left < right)
        {
            if(left + right == k)
            {
                return true;
            }
            if(left + right < k)
            {
                left = increasing.getNext();
            }
            else
            {
                right = decreasing.getNext();
            }
        }
        return false;
    }
    class BSTIterator
    {
        Stack<TreeNode> stack;
        boolean isAscending;
        public BSTIterator(TreeNode root, boolean isIncreasing)
        {
            stack = new Stack<>();
            isAscending = isIncreasing;
            pushNodes(root);
        }

        public int getNext()
        {
            TreeNode top = stack.pop();
            if(isAscending)
            {
                pushNodes(top.right);
            }
            else
            {
                pushNodes(top.left);
            }
            return top.val;
        }

        private void pushNodes(TreeNode current)
        {
            while(current != null)
            {
                stack.push(current);
                if(isAscending)
                {
                    current = current.left;
                }
                else
                {
                    current = current.right;
                }
            }
        }
    }
}