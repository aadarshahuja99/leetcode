class FreqStack {
    private HashMap<Integer, Integer> freq;
    private HashMap<Integer, Stack<Integer>> freqStack;
    private int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        freqStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        
        if (f > maxFreq) {
            maxFreq = f;
        }
        
        freqStack.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = freqStack.get(maxFreq);
        int val = stack.pop();
        
        freq.put(val, freq.get(val) - 1);
        
        if (stack.isEmpty()) {
            maxFreq--;
        }
        
        return val;
    }
}