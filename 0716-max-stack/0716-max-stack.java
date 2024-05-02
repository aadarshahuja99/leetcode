class MaxStack {
    Stack<int[]> stack;
    TreeMap<Integer,LinkedList<Integer>> values;
    int id;
    HashSet<Integer> removedIds;
    public MaxStack() {
        values = new TreeMap<>();
        stack = new Stack<>();
        id = 0;
        removedIds = new HashSet<>();
    }
    
    public void push(int x) {
        id++;
        stack.push(new int[] { id, x });
        if(!values.containsKey(x))
        {
            values.put(x, new LinkedList<>());
        }
        values.get(x).addLast(id);
    }
    
    public int pop() {
        while(!stack.isEmpty() && removedIds.contains(stack.peek()[0]))
        {
            stack.pop();
        }
        values.get(stack.peek()[1]).removeLast();
        if(values.get(stack.peek()[1]).size() == 0)
        {
            values.remove(stack.peek()[1]);
        }
        return stack.pop()[1];
    }
    
    public int top() {
        while(!stack.isEmpty() && removedIds.contains(stack.peek()[0]))
        {
            stack.pop();
        }
        return stack.peek()[1];
    }
    
    public int peekMax() {
        return values.lastKey();
    }
    
    public int popMax() {
        var entry = values.lastEntry();
        int removedId = entry.getValue().getLast();
        entry.getValue().removeLast();
        if(entry.getValue().isEmpty())
        {
            values.remove(entry.getKey());
        }
        removedIds.add(removedId);
        return entry.getKey();
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */