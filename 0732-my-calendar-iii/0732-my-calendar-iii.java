class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    // O(N) algorithm at each book call due to line sweep
    public int book(int startTime, int endTime) {
        map.put(startTime, map.getOrDefault(startTime,0)+1);
        map.put(endTime, map.getOrDefault(endTime,0)-1);
        int total = 0;
        int max = 0;
        for(var entry : map.entrySet())
        {
            total += entry.getValue();
            max = Math.max(max, total);
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */