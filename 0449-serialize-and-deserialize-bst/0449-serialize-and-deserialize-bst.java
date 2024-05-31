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
        if(root == null)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            return;
        }
        sb.append(root.val+",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
        {
            return null;
        }
        String[] values = data.split(",");
        int[] vals = new int[values.length];
        int idx = 0;
        for(String v : values)
        {
            vals[idx] = Integer.parseInt(v);
            idx++;
        }
        int[] index = {0};
        return getTree(index, vals, Integer.MAX_VALUE);
    }
    
    private TreeNode getTree(int[] currentIndex, int[] values, int maxSoFar)
    {
        if(currentIndex[0] >= values.length || values[currentIndex[0]] > maxSoFar)
        {
            return null;
        }
        TreeNode current = new TreeNode(values[currentIndex[0]++]);
        current.left = getTree(currentIndex, values, current.val);
        current.right = getTree(currentIndex, values, maxSoFar);
        return current;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;