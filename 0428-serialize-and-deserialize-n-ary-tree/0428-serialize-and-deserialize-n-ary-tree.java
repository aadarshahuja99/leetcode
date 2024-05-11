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

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null)
        {
            return "";
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node defaultEnd = new Node(-1);
        StringBuilder serializedTree = new StringBuilder();
        while(!queue.isEmpty())
        {
            var top = queue.poll();
            if(top != defaultEnd)
            {
                serializedTree.append(top.val);
                for(Node child : top.children)
                {
                    queue.add(child);
                }
                queue.add(defaultEnd); // end of current nodes children in queue
            }
            else
            {
                serializedTree.append("n");
            }
            serializedTree.append(" ");
        }
        return serializedTree.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.equals(""))
        {
            return null;
        }
        String[] values = data.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]), new ArrayList<Node>());
        queue.add(root);
        int currentIndex = 1;
        int n = values.length;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                for(int j=currentIndex; j<n; j++)
                {
                    if(values[j].equals("n"))
                    {
                        currentIndex = j+1;
                        break;
                    }
                    else
                    {
                        Node newNode = new Node(Integer.parseInt(values[j]), new ArrayList<Node>());
                        top.children.add(newNode);
                        queue.add(newNode);
                    }
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));