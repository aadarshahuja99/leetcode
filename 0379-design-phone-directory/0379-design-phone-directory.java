class PhoneDirectory {
    // log(n) operation using treeset. Can be optimized using hashmap and linkedList
    Node start;
    HashMap<Integer,Node> free;
    HashMap<Integer,Node> assigned;
    public PhoneDirectory(int maxNumbers) {
        free = new HashMap<>();
        assigned = new HashMap<>();
        start = null;
        Node current = null;
        for(int i=0; i<maxNumbers; i++)
        {
            Node newNode = new Node(i);
            free.put(i, newNode);
            if(start == null)
            {
                start = newNode;
            }
            if(current == null)
            {
                current = start;
            }
            else
            {
                current.next = newNode;
                current = current.next;
            }
        }
    }
    
    public int get() {
        if(free.size() == 0)
        {
            return -1;
        }
        Node next = start.next;
        Node toBeReturned = start;
        free.remove(toBeReturned.val);
        assigned.put(toBeReturned.val, toBeReturned);
        start = next;
        return toBeReturned.val;
    }
    
    public boolean check(int number) {
        return free.containsKey(number);
    }
    
    public void release(int number) {
        if(!assigned.containsKey(number))
        {
            return;
        }
        Node node = assigned.get(number);
        assigned.remove(number);
        free.put(number, node);
        node.next = start;
        start = node;
    }

    class Node
    {
        int val;
        Node next;
        public Node(int value)
        {
            val = value;
            next = null;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */