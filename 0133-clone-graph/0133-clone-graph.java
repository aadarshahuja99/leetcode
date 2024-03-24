/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> set = new HashMap<Integer,Node>();
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return null;
        }
        if(node.neighbors == null)
        {
            return new Node(1,null);
        }
        if(node.neighbors.size() == 0)
        {
            return new Node(1,new ArrayList<Node>());
        }
        return dfs(node);
    }
    private Node dfs(Node current)
    {
        int val = current.val;
        ArrayList<Node> adjs = new ArrayList<Node>();
        Node clone = new Node(val,adjs);
        set.put(val,clone);
        for(Node adj : current.neighbors)
        {
            if(!set.containsKey(adj.val))
            {
                adjs.add(dfs(adj));
            }
            else
            {
                adjs.add(set.get(adj.val));
            }
        }
        clone.neighbors = adjs;
        return clone;
    }
}