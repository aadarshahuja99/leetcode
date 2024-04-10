import java.util.SortedMap;
class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        var nextStart = map.ceilingEntry(start);
        var previousStart = map.floorEntry(start);
        // first entry
        if(nextStart == null && previousStart == null)
        {
            map.put(start, end);
            return true;
        }
        else if(previousStart == null)
        {
            // the current interval is the first interval
            if(nextStart.getKey() < end)
            {
                return false;
            }
            map.put(start, end);
            return true;
        }
        else if(nextStart == null)
        {
            if(previousStart.getValue() > start)
            {
                return false;
            }
            map.put(start, end);
            return true; 
        }
        else
        {
            if(nextStart.getKey() < end || previousStart.getValue() > start)
            {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */