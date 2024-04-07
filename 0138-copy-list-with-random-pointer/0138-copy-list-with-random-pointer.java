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
        if(head == null)
        {
            return head;
        }
        HashMap<Node,Node> visited = new HashMap<>();
        Node current = head;
        Node newCurrent = new Node(current.val);
        Node newHead = newCurrent;
        visited.put(current, newCurrent);
        while(current != null)
        {
            if(current.next != null && visited.containsKey(current.next))
            {
                newCurrent.next = visited.get(current.next);
            }
            else if(current.next != null)
            {
                newCurrent.next = new Node(current.next.val);
                visited.put(current.next, newCurrent.next);
            }
            if(current.random != null && visited.containsKey(current.random))
            {
                newCurrent.random = visited.get(current.random);
            }
            else if(current.random != null)
            {
                newCurrent.random = new Node(current.random.val);
                visited.put(current.random, newCurrent.random);
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }
}