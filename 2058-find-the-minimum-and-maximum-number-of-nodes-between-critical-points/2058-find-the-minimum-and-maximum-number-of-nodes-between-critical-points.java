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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null)
        {
            return new int[] { -1, -1 };
        }
        int firstIndex = -1;
        int lastIndex = -1;
        int currentIndex = 0;
        ListNode current = head;
        ListNode prev = null;
        ListNode next = head.next;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;
        while(next != null)
        {
            if(prev != null)
            {
                if((current.val < prev.val && current.val < next.val) || (current.val > prev.val && current.val > next.val))
                {
                    if(firstIndex == -1)
                    {
                        firstIndex = currentIndex;
                    }
                    else
                    {
                        maxDistance = currentIndex - firstIndex;
                    }
                    if(lastIndex != -1)
                    {
                        minDistance = Math.min(minDistance, currentIndex - lastIndex);
                    }
                    lastIndex = currentIndex;
                }
            }
            prev = current;
            current = current.next;
            next = current.next;
            currentIndex++;
        }
        if(maxDistance == -1)
        {
            return new int[] { -1, -1 };
        }
        return new int[] { minDistance, maxDistance };
    }
}