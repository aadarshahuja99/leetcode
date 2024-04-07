/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return getMaxDepth(root);
    }
    private int getMaxDepth(Node current)
    {
        if(current == null)
        {
            return 0;
        }
        int maxChildDepth = 0;
        for(Node child : current.children)
        {
            maxChildDepth = Math.max(getMaxDepth(child), maxChildDepth);
        }
        return 1+maxChildDepth;
    }
}