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
    public ListNode partition(ListNode head, int x) {
        // quick sort partition function
        ListNode smallerHead = null;
        ListNode smallerCurrent = smallerHead;
        ListNode largerHead = null;
        ListNode largerCurrent = largerHead;
        ListNode current = head;
        while(current != null)
        {
            ListNode next = current.next;
            if(current.val < x)
            {
                if(smallerCurrent == null)
                {
                    smallerCurrent = current;
                    smallerHead = smallerCurrent;
                }
                else
                {
                    smallerCurrent.next = current;
                    smallerCurrent = current;
                }
                smallerCurrent.next = null;
            }
            else
            {
                if(largerCurrent == null)
                {
                    largerCurrent = current;
                    largerHead = largerCurrent;
                }
                else
                {
                    largerCurrent.next = current;
                    largerCurrent = current;
                }
                largerCurrent.next = null;
            }
            current = next;
        }
        if(smallerHead == null)
        {
            return largerHead;
        }
        smallerCurrent.next = largerHead;
        return smallerHead;
    }
}