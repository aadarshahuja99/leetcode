class MyQueue {

    // 2 stacks and o(1) insert and amortized o(1) pop
    Stack<Integer> s1;
    Stack<Integer> s2;
    int front;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
        front = -1;
    }
    
    public void push(int x) {
        if(s1.isEmpty())
        {
            front = x;
        }
        s1.push(x);
    }
    
    public int pop() {
        if(!s2.isEmpty()) return s2.pop();
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty())
        {
            return front;
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */