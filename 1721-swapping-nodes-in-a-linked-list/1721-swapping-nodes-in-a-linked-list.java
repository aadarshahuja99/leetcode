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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null)
        {
            return head;
        }
        ListNode current = head;
        int i=1;
        while(i < k)
        {
            i++;
            current = current.next;
        }
        ListNode secondNode = head;
        ListNode firstNode = current;
        while(current.next != null)
        {
            current = current.next;
            secondNode = secondNode.next;
        }
        int temp = secondNode.val;
        secondNode.val = firstNode.val;
        firstNode.val = temp;
        return head;
    }
}