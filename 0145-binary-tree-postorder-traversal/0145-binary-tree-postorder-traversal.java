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
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<Integer> res = new ArrayDeque<>();
		if (root == null) return new ArrayList<>(res);
		TreeNode cur = root;
		while (cur != null) {
			if (cur.right != null) {
				TreeNode p = cur.right;
				while (p.left != null && p.left != cur) {
					p = p.left;
				}
				if (p.left == null) {
					p.left = cur;
					res.addFirst(cur.val);
					cur = cur.right;
				}
				else {
					p.left = null;
					cur = cur.left;
				}
			}
			else {
				res.addFirst(cur.val);
				cur = cur.left;
			}
		}
		return new ArrayList<>(res);
    }
}