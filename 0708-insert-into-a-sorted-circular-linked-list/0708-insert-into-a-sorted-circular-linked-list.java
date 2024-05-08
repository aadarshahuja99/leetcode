/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if(head == null)
        {
            head = newNode;
            head.next = head;
            return head;
        }
        // find the first element that is greater than the insertVal
        if(insertVal == head.val)
        {
            Node nextNode = head.next;
            head.next = newNode;
            newNode.next = nextNode;
            return head;
        }
        if(head.next == head)
        {
            head.next = newNode;
            newNode.next = head;
            return head;
        }
        Node current = head.next;
        Node prev = head;
        while(!(prev.val <= insertVal && current.val >= insertVal))
        {
            prev = current;
            current = current.next;
            if(prev == head)
            {
                break;
            }
        }
        if(!(prev.val <= insertVal && current.val >= insertVal))
        {
            current = head.next;
            while(current.val >= prev.val)
            {
                prev = current;
                current = current.next;
                if(prev == head)
                {
                    break;
                }
            }
        }
        prev.next = newNode;
        newNode.next = current;
        return head;
    }
}