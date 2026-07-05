public class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode current = slow.next;
        slow.next = null;
        ListNode prevReverse = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prevReverse;
            prevReverse = current;
            current = nextNode;
        }

        ListNode current2 = prevReverse;
        ListNode current1 = head;
        while(current2 != null)
        {
            System.out.println(current2.val);
            ListNode next1 = current1.next;
            ListNode next2 = current2.next;
            current1.next = current2;
            current2.next = next1;
            current1 = next1;
            current2 = next2;
        }
    }
}