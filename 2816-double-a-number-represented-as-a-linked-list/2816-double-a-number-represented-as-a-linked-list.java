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
    public ListNode doubleIt(ListNode head) {
        ListNode reversed = reverseList(head);
        ListNode current = reversed;
        int carry = 0;
        ListNode prev = null;
        current = reversed;
        while(current != null)
        {
            int val = current.val;
            int product = 2*val + carry;
            carry = product/10;
            int remainder = product%10;
            current.val = remainder;
            prev = current;
            current = current.next;
        }
        if(carry > 0)
        {
            prev.next = new ListNode(1);
            prev = prev.next;
        }
        return reverseList(reversed);
    }
    private ListNode reverseList(ListNode head)
    {
        ListNode current = head;
        ListNode prev = null;
        while(current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}