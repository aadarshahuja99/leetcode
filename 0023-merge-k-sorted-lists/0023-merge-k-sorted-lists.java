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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });
        for(ListNode currentHead : lists)
        {
            if(currentHead != null)
            {
                minHeap.add(currentHead);
            }
        }
        if(minHeap.size() == 0)
        {
            return null;
        }
        ListNode head = null;
        ListNode lastVisitedNode = null;
        while(minHeap.size() > 0)
        {
            ListNode currentNode = minHeap.poll();
            if(head == null)
            {
                head = currentNode;
            }
            if(lastVisitedNode != null)
            {
                lastVisitedNode.next = currentNode;
            }
            lastVisitedNode = currentNode;
            if(currentNode.next != null)
            {
                minHeap.add(currentNode.next);
            }
            currentNode.next = null;
        }
        return head;
    }
}