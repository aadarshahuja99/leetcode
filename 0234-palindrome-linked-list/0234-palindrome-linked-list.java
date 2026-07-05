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
    public boolean isPalindrome(ListNode head) {
        // hare and tortoise algorithm O(1) space
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode current = slow;
        while(current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current = head;
        ListNode reversedListCurrent = prev;
        while(current != slow && current.val == reversedListCurrent.val)
        {
            current = current.next;
            reversedListCurrent = reversedListCurrent.next;
        }
        return current == slow;
    }
}