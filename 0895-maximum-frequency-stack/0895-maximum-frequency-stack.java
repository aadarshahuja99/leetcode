class FreqStack {
    HashMap<Integer,Integer> countMap;
    PriorityQueue<int[]> pq;
    int insertIndex;
    public FreqStack() {
        countMap = new HashMap<Integer,Integer>();
        pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2)
            {
                if(e1[1] != e2[1])
                {
                    return e2[1] - e1[1];
                }
                return e2[2] - e1[2];
            }
        });
        insertIndex = 0;
    }
    
    public void push(int val) {
        insertIndex++;
        if(countMap.containsKey(val))
        {
            countMap.replace(val, countMap.get(val) + 1);
        }
        else
        {
            countMap.put(val,1);
        }
        int[] element = new int[] { val, countMap.get(val), insertIndex };
        pq.add(element);
    }
    
    public int pop() {
        var top = pq.poll();
        countMap.replace(top[0], countMap.get(top[0]) - 1);
        return top[0];
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */