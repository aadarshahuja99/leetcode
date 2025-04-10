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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
        {
            return head;
        }
        int length = 0;
        ListNode current = head;
        ListNode lastNode = null;
        while(current != null)
        {
            if(current.next == null)
            {
                lastNode = current;
            }
            current = current.next;
            length++;
        }
        if(k%length == 0)
        {
            return head;
        }
        lastNode.next = head;
        current = head;
        int numberOfRotations = k%length;
        int moves = length - numberOfRotations - 1;
        while(moves > 0)
        {
            current = current.next;
            moves--;
        }
        head = current.next;
        current.next = null;
        return head;
    }
}