/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        Node[] ans = dfs(root);
        if(ans[0] == null)
        {
            return null;
        }
        ans[0].left = ans[1];
        ans[1].right = ans[0];
        return ans[0];
    }
    private Node[] dfs(Node current)
    {
        if(current == null)
        {
            return new Node[2];
        }
        Node[] ans = new Node[2];
        var left = dfs(current.left);
        if(left[0] != null)
        {
            left[1].right = current;
            current.left = left[1];
            ans[0] = left[0];
        }
        else
        {
            ans[0] = current;
        }
        var right = dfs(current.right);
        if(right[1] != null)
        {
            current.right = right[0];
            right[0].left = current;
            ans[1] = right[1];
        }
        else
        {
            ans[1] = current;
        }
        return ans;
    }
}