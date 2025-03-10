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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right)
        {
            return head;
        }
        int counter = 1;
        ListNode current = head;
        ListNode prev = null;
        ListNode beforeStart = null;
        ListNode afterEnd = null;
        while(counter <= right)
        {
            if(counter == left)
            {
                beforeStart = prev;
            }
            if(counter > left && counter <= right)
            {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            else if(counter <= left)
            {
                prev = current;
                current = current.next;
            }
            counter++;
        }
        afterEnd = current;
        ListNode reversedListStart = null;
        if(beforeStart == null)
        {
            reversedListStart = head;
            head = prev;
        }
        else
        {
            reversedListStart = beforeStart.next;
            beforeStart.next = prev;
        }
        // System.out.println(afterEnd.val);
        reversedListStart.next = afterEnd;
        return head;
    }
}