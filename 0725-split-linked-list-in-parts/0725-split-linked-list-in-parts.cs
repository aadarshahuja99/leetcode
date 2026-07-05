/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode[] SplitListToParts(ListNode head, int k) {
        ListNode current = head;
        int length = 0;
        while(current != null)
        {
            current = current.next;
            length++;
        }
        ListNode[] ans = new ListNode[k];
        int minGroupSize = length/k;
        int numberOfGroupsWithExtra = length%k;
        int idx = 0;
        current = head;
        while(idx < k)
        {
            if(current == null)
            {
                ans[idx] = current;
                idx++;
                continue;
            }
            ListNode start = current;
            int grpLength = minGroupSize;
            if(idx < numberOfGroupsWithExtra)
            {
                grpLength++;
            }
            int c = 1;
            while(current != null && c < grpLength)
            {
                current = current.next;
                c++;
            }
            ListNode next = current.next;
            current.next = null;
            current = next;
            ans[idx] = start;
            idx++;
        }
        return ans;
    }
}