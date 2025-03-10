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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode ans = new ListNode();
        ListNode ansHead = ans;
        ListNode ansPrev = null;
        while(c1 != null && c2 != null)
        {
            int sum = carry + c1.val + c2.val;
            carry = sum/10;
            sum = sum%10;
            ans.val = sum;
            ans.next = new ListNode();
            ansPrev = ans;
            ans = ans.next;
            c1 = c1.next;
            c2 = c2.next;
        }
        while(c1 != null)
        {
            int sum = c1.val + carry;
            carry = sum/10;
            sum = sum%10;
            ans.val = sum;
            ans.next = new ListNode();
            ansPrev = ans;
            ans = ans.next;
            c1 = c1.next;
        }

        while(c2 != null)
        {
            int sum = c2.val + carry;
            carry = sum/10;
            sum = sum%10;
            ans.val = sum;
            ans.next = new ListNode();
            ansPrev = ans;
            ans = ans.next;
            c2 = c2.next;
        }

        if(carry > 0)
        {
            ans.val = carry;
            ans.next = new ListNode();
            ansPrev = ans;
            ans = ans.next;
        }

        ansPrev.next = null;
        return ansHead;
    }
}