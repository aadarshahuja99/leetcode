import java.util.*;
import java.util.Map.Entry;
class MyCalendarTwo {
    TreeMap<Integer,Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start,0) + 1);
        map.put(end, map.getOrDefault(end,0) - 1);
        int current = 0;
        for(Entry<Integer,Integer> activeEvents : map.entrySet())
        {
            current += activeEvents.getValue();
            if(current > 2)
            {
                map.replace(start, map.get(start)-1);
                map.replace(end, map.get(end)+1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */