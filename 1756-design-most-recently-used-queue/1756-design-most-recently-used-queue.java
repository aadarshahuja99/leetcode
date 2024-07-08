class MRUQueue {
    // square root decomposition
    int size;
    List<LinkedList<Integer>> blocks;
    public MRUQueue(int n) {
        size = (int)Math.ceil(Math.sqrt(n));
        blocks = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<size; i++)
        {
            blocks.add(new LinkedList<>());
            var current = blocks.get(i);
            for(int j=0; idx < n && j < size; j++)
            {
                // System.out.println("added "+idx+" to "+i+" block");
                current.add(++idx);
            }
        }
    }
    
    public int fetch(int k) {
        int block = (k-1)/blocks.size();
        int idx = (k-1)%blocks.size();
        int num = blocks.get(block).remove(idx);
        blocks.get(blocks.size()-1).addLast(num);
        for(int i=block+1; i<blocks.size(); i++)
        {
            blocks.get(i-1).addLast(blocks.get(i).removeFirst());
        }
        return num;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */