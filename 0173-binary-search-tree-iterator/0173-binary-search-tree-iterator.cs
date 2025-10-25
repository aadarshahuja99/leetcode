/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BSTIterator {
    // approach: use iterative inorder traversal to store all lefts in a stack
    Stack<TreeNode> stack = new();
    TreeNode current = null;
    public BSTIterator(TreeNode root) {
        current = root;
        while(current!=null)
        {
            stack.Push(current);
            current = current.left;
        }
    }
    
    public int Next() {
        var top = stack.Pop();
        if(top.right != null)
        {
            TreeNode temp = top.right;
            while(temp != null)
            {
                stack.Push(temp);
                temp=temp.left;
            }
        }
        return top.val;
    }
    
    public bool HasNext() {
        return stack.Count > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */