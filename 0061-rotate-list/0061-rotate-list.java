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
        ListNode last = null;
        HashMap<ListNode,ListNode> previousMap = new HashMap<>();
        while(current != null)
        {
            previousMap.put(current, last);
            last = current;
            current = current.next;
            length++;
        }
        if(k%length == 0)
        {
            return head;
        }
        int numberOfRotations = k%length;
        System.out.println(numberOfRotations);
        while(numberOfRotations > 0)
        {
            ListNode newLast = previousMap.get(last);
            newLast.next = null;
            // System.out.println(newLast.val+" "+last.val);
            last.next = head;
            head = last;
            last = newLast;
            numberOfRotations--;
        }
        return head;
    }
}