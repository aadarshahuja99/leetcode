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
        ListNode current = head;
        int i=1;
        while(i < n)
        {
            i++;
            current = current.next;
        }
        ListNode prev = null;
        while(current.next != null)
        {
            if(prev == null)
            {
                prev = head;
            }
            else
            {
                prev = prev.next;
            }
            current = current.next;
        }
        if(prev == null)
        {
            ListNode answer = head.next;
            head.next = null;
            return answer;
        }
        prev.next = prev.next.next;
        return head;
    }
}