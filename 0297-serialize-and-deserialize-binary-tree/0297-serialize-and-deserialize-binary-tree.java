/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            var top = queue.poll();
            if(top != null)
            {
                serializedTree.append(top.val);
                queue.add(top.left);
                queue.add(top.right);
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
    public TreeNode deserialize(String data) {
        System.out.println(data);
        String[] values = data.split(" ");
        if(values[0].equals("n"))
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = values.length;
        for(int i=1; i<size; i++)
        {
            var top = queue.poll();
            if(!values[i].equals("n"))
            {
                var left = new TreeNode(Integer.parseInt(values[i]));
                top.left = left;
                queue.add(left);
            }

            if(!values[++i].equals("n"))
            {
                var right = new TreeNode(Integer.parseInt(values[i]));
                top.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));