class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0)
        {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        if(map.size() < groupSize)
        {
            return false;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(var entry : map.entrySet())
        {
            minHeap.add(entry.getKey());
        }

        while(minHeap.size() > 0)
        {
            int top = minHeap.poll();
            HashSet<Integer> set = new HashSet<>();
            int last = top;
            for(int i=0; i<groupSize-1; i++)
            {
                if(minHeap.size() == 0)
                {
                    return false;
                }
                int next = minHeap.poll();
                if(map.get(next) == 0 || next != last+1)
                {
                    return false;
                }
                map.put(next, map.get(next) - 1);
                if(map.get(next) == 0)
                {
                    set.add(next);
                }
                last = next;
            }
            map.put(top, map.get(top) - 1);
            if(map.get(top) == 0)
            {
                set.add(top);
            }
            for(int it = top; it < top + groupSize; it++)
            {
                // not adding elements with zero current count to the minHeap
                if(set.contains(it))
                {
                    continue;
                }
                minHeap.add(it);
            }
        }
        // All groups should be completed by the end
        return true;
    }
}