/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 1st solution: HM<OriginalNode, NewNode>
        // optimized
        // 1. Insert a copied node of each current node next to it in the original list
        if(head == null)
        {
            return null;
        }
        Node cur = head;
        while(cur != null)
        {
            Node clonedNode = new Node(cur.val);
            Node next = cur.next;
            cur.next = clonedNode;
            clonedNode.next = next;
            cur = next;
        }
        cur = head;
        Node newHead = cur.next;
        // copy random pointers
        while(cur != null)
        {
            if(cur.random != null)
            {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        // copy next pointers
        while(cur != null)
        {
            Node next = cur.next.next;
            Node copy = cur.next;
            if(next != null)
            {
                copy.next = next.next;
            }
            cur.next = next;
            cur = next;
        }
        return newHead;
    }
}