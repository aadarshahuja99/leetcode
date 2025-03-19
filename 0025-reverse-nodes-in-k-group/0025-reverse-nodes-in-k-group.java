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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode lastGroupEnd = null;
        ListNode cur = head;
        ListNode prev = null;
        int c = 0;
        while(cur != null)
        {
            ListNode unreversedGroupStart = cur;
            ListNode tmp = cur;
            while(c < k && tmp != null)
            {
                tmp = tmp.next;
                c++;
            }
            if(c == k)
            {
                c = 0;
                while(cur != null && c < k)
                {
                    ListNode next = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = next;
                    c++;
                }
                if(lastGroupEnd != null)
                {
                    lastGroupEnd.next = prev;
                }
                else
                {
                    head = prev;
                }
                lastGroupEnd = unreversedGroupStart;
                lastGroupEnd.next = null;
                c = 0;
            }
            else
            {
                // System.out.println("c is less than k "+" unrev start "+unreversedGroupStart.val+" lastEnd "+lastGroupEnd.val);
                if(lastGroupEnd != null)
                {
                    lastGroupEnd.next = unreversedGroupStart;
                }
                cur = null;
            }
        }
        return head;
    }
}