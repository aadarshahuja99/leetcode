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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int c = 0;
        while(c < n)
        {
            cur = cur.next;
            c++;
        }
        if(cur == null)
        {
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        ListNode cur2 = head;
        while(cur.next != null)
        {
            cur = cur.next;
            cur2 = cur2.next;
        }
        ListNode next = cur2.next.next;
        cur2.next = next;
        return head;
    }
}