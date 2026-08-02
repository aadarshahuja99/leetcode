class Solution {
    public int[] amountPainted(int[][] paint) {
        // look for the floor key of the end point of each new interval to be painted. Basically, merge intervals using treemap
        TreeMap<Integer,Integer> disjointIntervals = new TreeMap<>();
        int[] newAreaToBePainted = new int[paint.length];
        int idx = 0;
        for(int[] interval : paint)
        {
            newAreaToBePainted[idx] = addNewIntervalAndReturnUniqueLength(interval[0], interval[1], disjointIntervals);
            idx++;
        }
        return newAreaToBePainted;
    }
    private int addNewIntervalAndReturnUniqueLength(int start, int end, TreeMap<Integer,Integer> map)
    {
        // insertion logic same as LC 3169 (Count number of days without meetings)
        int length = end - start;
        while(true)
        {
            var floor = map.floorEntry(end);
            if(floor == null || floor.getValue() < start)
            {
                break;
            }
            
            length -= Math.min(end, floor.getValue()) - Math.max(start, floor.getKey()); // subtract the intersection
            
            // compute the new combined (unioned) interval
            start = Math.min(start, floor.getKey());
            end = Math.max(end, floor.getValue());
            
            map.remove(floor.getKey());
        }
        map.put(start, end);
        return length;
    }
}