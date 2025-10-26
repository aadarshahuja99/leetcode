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
        while(c < n-1)
        {
            cur = cur.next;
            c++;
        }
        // assume 1->2->3->4 and n = 2. cur = 3, prev = 1
        ListNode prev = null;
        while(cur.next != null)
        {
            cur = cur.next;
            if(prev == null)
            {
                prev = head;
            }
            else
            {
                prev = prev.next;
            }
        }
        if(prev == null)
        {
            //remove the head node
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        else
        {
            // remove the node that is the next node of the 'prev' node
            ListNode next = prev.next.next;
            prev.next.next = null;
            prev.next = next;
        }
        return head;
    }
}