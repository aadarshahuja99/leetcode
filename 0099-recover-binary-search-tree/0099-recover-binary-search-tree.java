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
    TreeNode lastNode = null;
    TreeNode firstIncorrect = null;
    TreeNode lastIncorrect = null;
    TreeNode current = null;
    public void recoverTree(TreeNode root) {
        // morris inorder traversal + last popped element
        current = root;
        while(current != null)
        {
            if(current.left == null)
            {
                helper();
                current = current.right;
            }
            else
            {
                TreeNode leftChild = current.left;
                while(leftChild.right != null && leftChild.right != current)
                {
                    leftChild = leftChild.right;
                }
                if(leftChild.right == current)
                {
                    helper();
                    leftChild.right = null;
                    current = current.right;
                }
                else
                {
                    leftChild.right = current;
                    current = current.left;
                }
            }
        }
        int temp = firstIncorrect.val;
        firstIncorrect.val = lastIncorrect.val;
        lastIncorrect.val = temp;
        return;
    }
    private void helper()
    {
        if(lastNode != null)
        {
            int currentValue = current.val;
            if(currentValue < lastNode.val)
            {
                if(firstIncorrect == null)
                {
                    firstIncorrect = lastNode;
                    lastIncorrect = current;
                }
                else
                {
                    lastIncorrect = current;
                }
            }
        }
        lastNode = current;
    }
}