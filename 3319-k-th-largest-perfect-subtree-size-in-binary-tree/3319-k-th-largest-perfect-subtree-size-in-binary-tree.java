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
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> { return b - a; });
        dfs(root, pq);
        if(pq.size() < k)
        {
            return -1;
        }
        int ansHeight = 0;
        while(k > 0)
        {
            ansHeight = pq.poll();
            k--;
        }
        return (int)Math.pow(2, ansHeight) - 1;
    }
    private int[] dfs(TreeNode root, PriorityQueue<Integer> pq)
    {
        if(root == null)
        {
            return new int[] { 0, 0 };
        }
        if(root.left == null && root.right == null)
        {
            pq.add(1);
            return new int[] { 1, 1 };
        }
        int[] leftStatus = dfs(root.left, pq);
        int[] rightStatus = dfs(root.right, pq);
        boolean isPerfect = leftStatus[1] == rightStatus[1] && leftStatus[0] == 1 && rightStatus[0] == 1;
        if(isPerfect)
        {
            pq.add(leftStatus[1]+1);
            return new int[] { 1, leftStatus[1] + 1 };
        }
        return new int[] { 0, 0 };
    }
}