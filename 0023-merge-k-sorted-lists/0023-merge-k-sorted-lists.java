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
        ListNode lastVisitedNode = minHeap.poll();
        if(lastVisitedNode.next != null)
        {
            minHeap.add(lastVisitedNode.next);
            lastVisitedNode.next = null;
        }
        ListNode head = lastVisitedNode;
        while(minHeap.size() > 0)
        {
            lastVisitedNode.next = minHeap.poll();
            lastVisitedNode = lastVisitedNode.next;
            if(lastVisitedNode.next != null)
            {
                minHeap.add(lastVisitedNode.next);
                lastVisitedNode.next = null;
            }
        }
        return head;
    }
}