/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null)
        {
            return null;
        }
        return flattenListHelper(head,null,head);
    }
    private Node flattenListHelper(Node current, Node nodeToBeAppended, Node head)
    {
        if(current == null)
        {
            return head;
        }
        if(current.next == null && current.child == null)
        {
            if(nodeToBeAppended != null)
            {
                // System.out.println("at "+current.val+" appending "+nodeToBeAppended.val);
                current.next = nodeToBeAppended;
                nodeToBeAppended.prev = current;
            }
            return head;
        }
        if(current.child != null)
        {
            Node existingNext = current.next;
            Node child = flattenListHelper(current.child, existingNext, current.child);
            // System.out.println("received " + child.val + " for "+current.val);
            current.next = child;
            child.prev = current;
            current.child = null;
        }
        return flattenListHelper(current.next, nodeToBeAppended, head);
    }
}