class CountIntervals {
    TreeMap<Integer,Integer> map;
    int uniqueIntegersPresentOverall;
    public CountIntervals() {
        map = new TreeMap<>();
        uniqueIntegersPresentOverall = 0;
    }
    
    public void add(int left, int right) {
        uniqueIntegersPresentOverall += insert(left, right);
    }

    private int insert(int start, int end)
    {
        int total = end - start + 1;
        while(true)
        {
            var floor = map.floorEntry(end);
            if(floor == null || floor.getValue() < start)
            {
                break;
            }
            total -= (Math.min(floor.getValue(), end) - Math.max(floor.getKey(), start) + 1);
            start = Math.min(start, floor.getKey());
            end = Math.max(end, floor.getValue());
            map.remove(floor.getKey());
        }
        map.put(start, end);
        return total;
    }

    public int count() {
        return uniqueIntegersPresentOverall;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */