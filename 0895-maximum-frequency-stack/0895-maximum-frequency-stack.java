class FreqStack {
    HashMap<Integer,Integer> countMap;
    PriorityQueue<int[]> pq;
    int insertIndex;
    public FreqStack() {
        countMap = new HashMap<Integer,Integer>();
        pq = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            return a[1] == b[1] ? b[2] - a[2] : b[1] - a[1];
        });
        insertIndex = 0;
    }
    
    public void push(int val) {
        insertIndex++;
        countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        int[] element = new int[] { val, countMap.get(val), insertIndex };
        pq.add(element);
    }
    
    public int pop() {
        var top = pq.poll();
        int val = top[0];
        countMap.put(val, countMap.get(val) - 1);
        if(countMap.get(val) == 0)
        {
            countMap.remove(val);
        }
        return top[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */