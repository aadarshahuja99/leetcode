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
    HashMap<Integer,Integer> preOrderIndices = new HashMap<>();
    HashMap<Integer,Integer> postOrderIndices = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for(int i=0; i<postorder.length; i++)
        {
            preOrderIndices.put(preorder[i],i);
            postOrderIndices.put(postorder[i],i);
        }
        int n = preorder.length;
        return getTree(0,n-1,0,n-1,preorder,postorder);
    }
    private TreeNode getTree(int preorderstart, int preorderend, int postorderstart, int postorderend, int[] preorder, int[] postorder)
    {
        // System.out.println(preorderstart + " " + preorderend + " " + postorderstart + " " + postorderend);
        if(preorderstart > preorderend)
        {
            return null;
        }
        TreeNode currentNode = new TreeNode(preorder[preorderstart]);
        TreeNode leftSubtree = null;
        if(preorderstart < preorderend && !visited.contains(preorder[preorderstart+1]))
        {
            int leftChildValue = preorder[preorderstart+1];
            int leftChildIndexInPostOrder = postOrderIndices.get(leftChildValue);
            int leftSubTreeSize = leftChildIndexInPostOrder - postorderstart + 1;
            int leftSubTreeEndIndex = preorderstart + leftSubTreeSize;
            visited.add(leftChildValue);
            leftSubtree = getTree(preorderstart+1, leftSubTreeEndIndex, postorderstart, leftChildIndexInPostOrder, preorder, postorder);
        }
        TreeNode rightSubtree = null;
        if(postorderend > postorderstart && !visited.contains(postorder[postorderend-1]))
        {
            int rightChildValue = postorder[postorderend-1];
            int rightChildIndexInPreOrder = preOrderIndices.get(rightChildValue);
            int rightSubTreeSize = preorderend - rightChildIndexInPreOrder + 1;
            int rightSubTreeStartIndex =  postorderend - rightSubTreeSize;
            visited.add(rightChildValue);
            rightSubtree = getTree(rightChildIndexInPreOrder, preorderend, rightSubTreeStartIndex, postorderend - 1, preorder, postorder);
        }
        currentNode.left = leftSubtree;
        currentNode.right = rightSubtree;
        return currentNode;
    }
}