/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode SortList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode mid = GetMiddleNode(head);
        ListNode next = mid.next;
        mid.next = null;
        if(head.next!=null)
        {
            Console.WriteLine($"{mid.val}, {head.val}, {head.next.val}");
        }
        var leftSortedList = SortList(head);
        var rightSortedList = SortList(next);
        return MergeTwoLists(leftSortedList, rightSortedList);
    }
    private ListNode GetMiddleNode(ListNode head)
    {
        if(head.next.next == null)
        {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode MergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode node;
        if(l1==null){
            return l2;
        }
        else if(l2==null){
            return l1;
        }
        else{
            if(l1.val<=l2.val){
                node=l1;
                node.next=MergeTwoLists(l1.next,l2);
            }
            else{
                node=l2;
                node.next=MergeTwoLists(l1,l2.next);
            }
        }
        return node;
    }
}