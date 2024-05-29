/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    public NodeCopy copyRandomBinaryTree(Node root) {
        if(root == null)
        {
            return null;
        }
        NodeCopy clone = new NodeCopy(root.val);
        HashMap<Node,NodeCopy> visited = new HashMap<>();
        visited.put(root, clone);
        dfs(root, clone, visited);
        return clone;
    }
    private void dfs(Node root, NodeCopy clone, HashMap<Node,NodeCopy> visited)
    {
        // left
        if(root.left == null && root.right == null && root.random == null)
        {
            return;
        }
        if(root.left != null && !visited.containsKey(root.left))
        {
            clone.left = new NodeCopy(root.left.val);
            visited.put(root.left, clone.left);
            dfs(root.left, clone.left, visited);
        }
        else if(visited.containsKey(root.left))
        {
            clone.left = visited.get(root.left);
        }
        
        // right
        if(root.right != null && !visited.containsKey(root.right))
        {
            clone.right = new NodeCopy(root.right.val);
            visited.put(root.right, clone.right);
            dfs(root.right, clone.right, visited);
        }
        else if(visited.containsKey(root.right))
        {
            clone.right = visited.get(root.right);
        }

        // random
        if(root.random != null && !visited.containsKey(root.random))
        {
            clone.random = new NodeCopy(root.random.val);
            visited.put(root.random, clone.random);
            dfs(root.random, clone.random, visited);
        }
        else if(visited.containsKey(root.random))
        {
            clone.random = visited.get(root.random);
        }
    }
}