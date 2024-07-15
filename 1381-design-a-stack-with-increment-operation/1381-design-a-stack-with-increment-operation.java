class CustomStack {
    int n;
    Stack<Integer> stack;
    int[] increments;
    public CustomStack(int maxSize) {
        n = maxSize;
        stack = new Stack<>();
        increments = new int[n];
    }
    
    public void push(int x) {
        if(stack.size() >= n)
        {
            return;
        }
        stack.push(x);
    }
    
    public int pop() {
        if(stack.size() == 0)
        {
            return -1;
        }
        int maxId = stack.size() - 1;
        int val = increments[maxId];
        if(maxId > 0)
        {
            increments[maxId-1] += val;
        }
        increments[maxId] = 0;
        System.out.println(val);
        return val + stack.pop();
    }
    
    public void increment(int k, int val) {
        if(k == 0)
        {
            return;
        }
        if(k > stack.size())
        {
            k = stack.size();
        }
        if(k == 0)
        {
            return;
        }
        increments[k-1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */