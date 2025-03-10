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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
        {
            return head;
        }
        ListNode evenStart = null;
        ListNode oddStart = null;
        ListNode even = null;
        ListNode odd = null;
        int c = 1;
        ListNode curr = head;
        while(curr != null)
        {
            if(c == 1)
            {
                oddStart = curr;
                odd = oddStart;
            }
            else if(c == 2)
            {
                evenStart = curr;
                even = evenStart;
            }
            else
            {
                if(c%2 == 1)
                {
                    odd.next = curr;
                    odd = odd.next;
                }
                else
                {
                    even.next = curr;
                    even = even.next;
                }
            }
            curr = curr.next;
            if(even != null)
            {
                even.next = null;
            }
            if(odd != null)
            {
                odd.next = null;
            }
            c++;
        }
        odd.next = evenStart;
        return head;
    }
}