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
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode segmentStart = head;
        ListNode prev = null;
        int currentZeroCount = 0;
        int currentSum = 0;
        while(current != null)
        {
            currentSum += current.val;
            // System.out.println(current.val+" "+currentSum);
            if(current.val == 0 && currentSum > 0)
            {
                ListNode newNode = new ListNode(currentSum);
                segmentStart.next = newNode;
                newNode.next = current;
                segmentStart = newNode;
                currentSum = 0;
            }
            current = current.next;
        }
        segmentStart.next = null;
        return head.next;
    }
}