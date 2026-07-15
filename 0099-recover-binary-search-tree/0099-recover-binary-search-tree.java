class Solution {
    public void recoverTree(TreeNode root) {
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