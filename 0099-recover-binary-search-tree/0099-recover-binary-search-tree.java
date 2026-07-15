class Solution {
    public void recoverTree(TreeNode root) {
        // Intuition: if there is only one violation (only 2 nodes in incorrect places), then swap them (this happens when incorrect nodes are adjacent to each other in inorder)
        // else if there is one more violation (when the incorrect nodes are not adjacent, then replace the initially set second incorrect node with the new smaller incorrect node 'b' in this solution)
        TreeNode a = null, b = null, prev = null;
        // Morris Traversal
        TreeNode node = root;
        while(node != null) {
            if(node.left == null) {
                // Specific to this problem (Not Required in Morris Traversal), this is being done to check if the inorder predecessor is more in value than the current node, if so, then it is an anomaly
                if(prev != null && prev.val > node.val) {
                    if (a == null) {
                        a = prev;
                    }
                    b = node;
                }
                prev = node;
                node = node.right;
            } else {
                TreeNode predecessor = findPredecessor(node.left, node);
                if(predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
					// Specific to this problem (Not Required in Morris Traversal), this is being done to check if the inorder predecessor is more in value than the current node, if so, then it is an anomaly
                    if(prev != null && prev.val > node.val) {
                        if(a == null) {
                            a = prev;
                        }
                        b = node;
                    }
                    prev = node;
                    node = node.right;
                }
            }
        }
        // simply swap the two incorrect values
        int data = a.val;
        a.val = b.val;
        b.val = data;
    }
    
    TreeNode findPredecessor(TreeNode node, TreeNode cur) {
        while(node.right != null && node.right != cur) {
            node = node.right;
        }
        return node;
    }
}