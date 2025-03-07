class HitCounter {
    Queue<Integer> timeStamps;
    final static int MAX_QUEUE_SIZE = 300;
    public HitCounter() {
        timeStamps = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        while(!timeStamps.isEmpty() && (timestamp - timeStamps.peek()) >= 300)
        {
            timeStamps.poll();
        }
        timeStamps.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        if(timeStamps.isEmpty())
        {
            return 0;
        }
        while(!timeStamps.isEmpty() && (timestamp - timeStamps.peek()) >= MAX_QUEUE_SIZE)
        {
            timeStamps.poll();
        }
        return timeStamps.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */