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
        // assume 1->2->3->4 and n = 2. cur = 3, prev = 1
        ListNode prev = head;
        while(cur.next != null)
        {
            cur = cur.next;
            prev = prev.next;
        }
        ListNode next = prev.next.next;
        prev.next = next;
        return head;
    }
}