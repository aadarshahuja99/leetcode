class BoundedBlockingQueue {
    Queue<Integer> queue;
    int limit;
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        limit = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        synchronized(this)
        {
            while(queue.size() == limit)
            {
                this.wait();
            }
            queue.add(element);
            this.notifyAll();
        }
    }
    
    public int dequeue() throws InterruptedException {
        int top = -1;
        synchronized(this)
        {
            while(queue.isEmpty())
            {
                this.wait();
            }
            top = queue.poll();
            this.notifyAll();
        }
        return top;
    }
    
    public int size() {
        return queue.size();
    }
}