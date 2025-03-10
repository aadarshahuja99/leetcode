/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // optimized approach for interviews
        // move c1 and c2 while they are not the same, if c1 and c2 become equal, return c1
        // else if c1 is null make it point to head2, else if c2 is null make it point to head1
        ListNode c1 = headA;
        ListNode c2 = headB;
        while(c1 != c2)
        {
            c1 = c1.next;
            c2 = c2.next;
            if(c1 == c2)
            {
                return c1;
            }
            if(c1 == null)
            {
                c1 = headB;
            }
            if(c2 == null)
            {
                c2 = headA;
            }
        }
        return c1;
    }
}