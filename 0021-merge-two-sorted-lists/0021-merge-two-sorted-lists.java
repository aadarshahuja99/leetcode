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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = null;
        ListNode head = null;
        while(list1 != null && list2 != null)
        {
            if(list1.val > list2.val)
            {
                if(current == null)
                {
                    current = list2;
                }
                else
                {
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
            else
            {
                if(current == null)
                {
                    current = list1;
                }
                else
                {
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }
            if(head == null)
            {
                head = current;
            }
        }
        if(list1 != null)
        {
            if(current == null)
            {
                current = list1;
                head = current;
            }
            else
            {
                current.next = list1;
            }
        }
        if(list2 != null)
        {
            if(current == null)
            {
                current = list2;
                head = current;
            }
            else
            {
                current.next = list2;
            }
        }
        return head;
    }
}