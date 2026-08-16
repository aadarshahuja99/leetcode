class BoundedBlockingQueue {
    Queue<Integer> queue;
    int limit;
    ReentrantLock lock;
    Condition notFull;
    Condition notEmpty;
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList<>();
        limit = capacity;
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }
    
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try
        {
            while(queue.size() == limit)
            {
                notFull.await();
            }
            queue.add(element);
            notEmpty.signal();
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
        lock.lock();
        try
        {
            while(queue.isEmpty())
            {
                notEmpty.await();
            }
            int top = queue.poll();
            notFull.signal();
            return top;
        }
        finally
        {
            lock.unlock();
        }
    }
    
    public int size() {
        return queue.size();
    }
}