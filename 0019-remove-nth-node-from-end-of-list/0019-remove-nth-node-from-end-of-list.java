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
        int numberOfJumps = 0;
        while(numberOfJumps < n-1)
        {
            current = current.next;
            numberOfJumps++;
        }
        ListNode toBeRemoved = head;
        ListNode prev = null;
        while(current.next != null)
        {
            current = current.next;
            prev = toBeRemoved;
            toBeRemoved = toBeRemoved.next;
        }
        ListNode next = toBeRemoved.next;
        if(prev == null)
        {
            head.next = null;
            head = next;
        }
        else
        {
            prev.next = next;
        }
        return head;
    }
}