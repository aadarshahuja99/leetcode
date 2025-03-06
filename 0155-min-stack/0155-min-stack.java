class MinStack {
    Long minVal;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(minVal == null)
        {
            minVal = 1l*val;
            st.push(1l*val);
            return;
        }
        if(minVal > val)
        {
            st.push(2l*val - minVal);
            minVal = 1l*val;
        }
        else
        {
            st.push(1l*val);
        }
    }
    
    public void pop() {
        Long val = st.peek();
        if(minVal != null && val < minVal)
        {
            minVal = 2l*minVal - val;
        }
        if(st.size() == 1)
        {
            minVal = null;
        }
        st.pop();
    }
    
    public int top() {
        if(minVal != null && st.peek() < minVal)
        {
            return minVal.intValue();
        }
        return st.peek().intValue();
    }
    
    public int getMin() {
        return minVal.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */