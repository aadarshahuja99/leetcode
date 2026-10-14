/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode current = head;
        while(current != null)
        {
            list.add(current);
            current = current.next;
        }
        return getBST(list, 0, list.size() - 1);
    }
    private TreeNode getBST(List<ListNode> list, int start, int end)
    {
        if(start > end)
        {
            return null;
        }
        int mid = start + (end - start)/2;
        ListNode midNode = list.get(mid);
        TreeNode newNode = new TreeNode(midNode.val);
        newNode.right = getBST(list, mid+1, end);
        newNode.left = getBST(list, start, mid-1);
        return newNode;
    }
}