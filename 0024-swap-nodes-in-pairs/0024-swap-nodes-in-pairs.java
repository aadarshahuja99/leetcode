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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode current = head.next;
        ListNode prev = head;
        ListNode previousToPrev = null;
        while(current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev.next = next;
            if(previousToPrev != null)
            {
                previousToPrev.next = current;
            }
            else
            {
                head = current;
            }
            if(next == null)
            {
                break;
            }
            previousToPrev = prev;
            current = next.next;
            prev = next;
        }
        return head;
    }
}