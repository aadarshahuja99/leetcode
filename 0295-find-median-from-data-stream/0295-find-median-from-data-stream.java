class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0)
        {
            maxHeap.add(num);
            return;
        }
        if(num < maxHeap.peek())
        {
            maxHeap.add(num);
            // System.out.println("1 :added "+num+" to 1st half");
            if(maxHeap.size() > minHeap.size() + 1)
            {
                // System.out.println("1: added "+num+" from 1st to 2nd half");
                minHeap.add(maxHeap.poll());
            }
        }
        else
        {
            minHeap.add(num);
            // System.out.println("2: added "+num+" to 2nd half");
            if(minHeap.size() > maxHeap.size())
            {
                // System.out.println("2: added "+minHeap.peek()+" to 1st half");
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        // System.out.println(maxHeap.size() + " " + minHeap.size());
        if(maxHeap.size() == minHeap.size() + 1)
        {
            return maxHeap.peek();
        }
        return (double)(maxHeap.peek() + minHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */