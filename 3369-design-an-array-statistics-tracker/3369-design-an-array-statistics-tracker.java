class StatisticsTracker {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> {
        return b-a;
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    Queue<Integer> queue = new LinkedList<>();
    long total = 0l;
    int n = 0;
    HashMap<Integer,Integer> freqMap = new HashMap<>();
    TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();
    
    public StatisticsTracker() {
        
    }
    
    public void addNumber(int number) {
        queue.add(number);
        addToPQs(number);
        total += number;
        freqMap.put(number, freqMap.getOrDefault(number, 0) + 1);
        if(!map.containsKey(freqMap.get(number)))
        {
            map.put(freqMap.get(number), new TreeSet<>());
        }
        map.get(freqMap.get(number)).add(number);
        if(map.containsKey(freqMap.get(number)-1) && map.get(freqMap.get(number)-1).contains(number))
        {
            map.get(freqMap.get(number)-1).remove(number);
        }
        n++;
    }

    private void addToPQs(int num)
    {
        if(minHeap.isEmpty() && maxHeap.isEmpty())
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

    private void removeFromPQs(int num)
    {
        if(num <= maxHeap.peek())
        {
            maxHeap.remove(num);
        }
        else
        {
            minHeap.remove(num);
        }
        if(maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > minHeap.size() + 1)
        {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public void removeFirstAddedNumber() {
        int number = queue.poll();
        total -= number;
        n--;
        removeFromPQs(number);

        freqMap.put(number, freqMap.getOrDefault(number, 0) - 1);
        if(freqMap.get(number) == 0)
        {
            freqMap.remove(number);
            map.get(1).remove(number);
        }
        else
        {
            map.get(freqMap.get(number)+1).remove(number);
            if(map.get(freqMap.get(number)+1).size() == 0)
            {
                map.remove(freqMap.get(number)+1);
            }
            if(!map.containsKey(freqMap.get(number)))
            {
                map.put(freqMap.get(number), new TreeSet<>());
            }
            map.get(freqMap.get(number)).add(number);
        }
    }
    
    public int getMean() {
        return (int)(total/n);
    }
    
    public int getMedian() {
        if(n%2 == 1)
        {
            return maxHeap.peek();
        }
        return minHeap.peek();
    }
    
    public int getMode() {
        return map.get(map.lastKey()).first();
    }
}

/**
 * Your StatisticsTracker object will be instantiated and called as such:
 * StatisticsTracker obj = new StatisticsTracker();
 * obj.addNumber(number);
 * obj.removeFirstAddedNumber();
 * int param_3 = obj.getMean();
 * int param_4 = obj.getMedian();
 * int param_5 = obj.getMode();
 */