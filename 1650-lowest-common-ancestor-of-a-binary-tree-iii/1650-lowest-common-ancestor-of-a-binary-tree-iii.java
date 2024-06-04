/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node current = p;
        while(current.parent != null)
        {
            current = current.parent;
        }
        return findLCA(current, p, q);
    }
    private Node findLCA(Node current, Node p, Node q)
    {
        if(current == null)
        {
            return null;
        }
        if(current.val == p.val || current.val == q.val)
        {
            return current;
        }
        Node left = findLCA(current.left, p, q);
        Node right = findLCA(current.right, p, q);
        if(left != null && right != null)
        {
            return current;
        }
        return left != null ? left : right;
    }
}