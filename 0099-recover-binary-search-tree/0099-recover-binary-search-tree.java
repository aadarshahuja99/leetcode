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
    public void recoverTree(TreeNode root) {
        // morris inorder traversal + last popped element
        TreeNode lastNode = null;
        TreeNode firstIncorrect = null;
        TreeNode lastIncorrect = null;
        TreeNode current = root;
        while(current != null)
        {
            if(current.left == null)
            {
                var changed = helper(current,lastNode,firstIncorrect,lastIncorrect);
                firstIncorrect = changed.getKey();
                lastIncorrect = changed.getValue();
                lastNode = current;
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
                    var changed = helper(current,lastNode,firstIncorrect,lastIncorrect);
                    firstIncorrect = changed.getKey();
                    lastIncorrect = changed.getValue();
                    leftChild.right = null;
                    lastNode = current;
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
    private Pair<TreeNode,TreeNode> helper(TreeNode current, TreeNode lastNode, TreeNode firstIncorrect, TreeNode lastIncorrect)
    {
        if(lastNode == null)
        {
            lastNode = current;
        }
        else
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
        return new Pair<TreeNode,TreeNode>(firstIncorrect, lastIncorrect);
    }
}