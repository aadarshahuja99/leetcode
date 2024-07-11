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
        return getBST(head);
    }
    private TreeNode getBST(ListNode current)
    {
        if(current == null)
        {
            return null;
        }
        ListNode[] temp = getMiddle(current);
        ListNode middle = temp[1];
        ListNode prev = temp[0];
        ListNode next = middle.next;
        TreeNode newNode = new TreeNode(middle.val);
        newNode.right = getBST(next);
        if(prev != null)
        {
            prev.next = null;
            newNode.left = getBST(current);
        }
        return newNode;
    }
    private ListNode[] getMiddle(ListNode start)
    {
        ListNode prev = null;
        ListNode slow = start;
        ListNode fast = start.next;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return new ListNode[]  { prev, slow };
    }
}