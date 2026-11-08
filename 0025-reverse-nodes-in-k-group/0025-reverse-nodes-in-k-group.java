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
        if(k == 1)
        {
            return head;
        }
        ListNode lastGroupEnd = null;
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null)
        {
            ListNode unreversedGroupStart = cur;
            ListNode tmp = cur;
            int c = 0;
            while(c < k && tmp != null)
            {
                tmp = tmp.next;
                c++;
            }
            if(c == k)
            {
                c = 0;
                while(c < k)
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
            }
            else
            {
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