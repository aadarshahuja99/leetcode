import java.util.*;
import java.util.Map.Entry;
class MyCalendarTwo {
    SortedMap<Integer,Integer> map;
    public MyCalendarTwo() {
        map = new TreeMap<Integer,Integer>();
    }
    
    public boolean book(int start, int end) {
        if(map.containsKey(start))
        {
            map.replace(start, map.get(start)+1);
        }
        else
        {
            map.put(start,1);
        }
        if(map.containsKey(end))
        {
            map.replace(end, map.get(end)-1);
        }
        else
        {
            map.put(end,-1);
        }
        int current = 0;
        for(Entry<Integer,Integer> activeEvents : map.entrySet())
        {
            current += activeEvents.getValue();
            if(current > 2)
            {
                map.replace(start, map.get(start)-1);
                map.replace(end, map.get(end)+1);
                // if(map.get(start) == 0)
                // {
                //     map.remove(start);
                //     map.remove(end);
                // }
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