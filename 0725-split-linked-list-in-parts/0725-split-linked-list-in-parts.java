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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while(current != null)
        {
            current = current.next;
            length++;
        }
        // System.out.println(length);
        int minGroupSize = length/k;
        int maxGroups = length%k;
        List<ListNode> starts = new ArrayList<>();
        current = head;
        int numberOfMinGroups = k - maxGroups;
        
        ListNode prev = null;
        if(maxGroups > 0)
        {
            int maxGroupSize = length/k + 1;
            while(maxGroups > 0)
            {
                int currentSize = maxGroupSize;
                ListNode start = current;
                while(currentSize > 0)
                {
                    prev = current;
                    currentSize--;
                    current = current.next;
                }
                starts.add(start);
                prev.next = null;
                maxGroups--;
            }
        }

        while(numberOfMinGroups > 0)
        {
            if(minGroupSize == 0)
            {
                starts.add(null);
            }
            else
            {
                int currentSize = minGroupSize;
                ListNode start = current;
                while(currentSize > 0)
                {
                    prev = current;
                    current = current.next;
                    currentSize--;
                }
                starts.add(start);
                prev.next = null;
            }
            numberOfMinGroups--;
        }
        ListNode[] ans = new ListNode[starts.size()];
        int idx = 0;
        for(ListNode start : starts)
        {
            ans[idx] = start;
            idx++;
        }
        return ans;
    }
}