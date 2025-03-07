class MyCalendar {
    TreeMap<Integer,Integer> events;
    public MyCalendar() {
        events = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        var floorEntry = events.floorEntry(startTime);
        var ceilingEntry = events.ceilingEntry(startTime);
        if(floorEntry == null || floorEntry.getValue() <= startTime)
        {
            if(ceilingEntry == null || ceilingEntry.getKey() >= endTime)
            {
                events.put(startTime, endTime);
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */