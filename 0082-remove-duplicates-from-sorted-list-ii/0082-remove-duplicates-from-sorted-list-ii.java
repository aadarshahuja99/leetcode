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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while(current != null)
        {
            int length = 1;
            while(current.next != null && current.next.val == current.val)
            {
                length++;
                current = current.next;
            }
            if(length > 1)
            {
                ListNode next = current.next;
                if(previous != null)
                {
                    previous.next = next;
                    current.next = null;
                }
                else
                {
                    head = next;
                    current.next = null;
                }
                current = next;
            }
            else
            {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}