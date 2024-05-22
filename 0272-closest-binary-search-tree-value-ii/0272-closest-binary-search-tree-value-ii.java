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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        BSTIterator pre = new BSTIterator(false, target, root);
        BSTIterator succ = new BSTIterator(true, target, root);
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            if(pre.peek() == -1)
            {
                res.add(succ.peek());
                succ.updateStack();
            }
            else if(succ.peek() == -1)
            {
                res.add(pre.peek());
                pre.updateStack();
            }
            else
            {
                if(Math.abs((double)pre.peek() - target) >= Math.abs((double)succ.peek() - target))
                {
                    res.add(succ.peek());
                    succ.updateStack();
                }
                else
                {
                    res.add(pre.peek());
                    pre.updateStack();
                }
            }
        }
        return res;
    }
    class BSTIterator
    {
        boolean isSuccessor;
        Stack<TreeNode> stack;
        double target;
        TreeNode root;
        public BSTIterator(boolean isSuc, double t, TreeNode r)
        {
            stack = new Stack<>();
            isSuccessor = isSuc;
            target = t;
            root = r;
            build();
        }
        public void build()
        {
            TreeNode current = root;
            while(current != null)
            {
                // System.out.println(current.val+" "+target+" "+isSuccessor);
                if((double)current.val >= target)
                {
                    if(isSuccessor)
                    {
                        // System.out.println("pushed "+current.val+" to succ stack");
                        stack.push(current);
                    }
                    current = current.left;
                }
                else
                {
                    if(!isSuccessor)
                    {
                        // System.out.println("pushed "+current.val+" to pre stack");
                        stack.push(current);
                    }
                    current = current.right;
                }
            }
        }
        public int peek()
        {
            if(stack.isEmpty())
            {
                return -1;
            }
            return stack.peek().val;
        }
        public void updateStack()
        {
            TreeNode top = stack.pop();
            top = isSuccessor ? top.right : top.left;
            while(top != null)
            {
                stack.push(top);
                top = isSuccessor ? top.left : top.right;
            }
        }
    }
}