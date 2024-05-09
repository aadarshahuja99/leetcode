/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Interval> freeTimes = new ArrayList<>();
        for(List<Interval> employeeTimes : schedule)
        {
            for(Interval interval : employeeTimes)
            {
                addNewInterval(interval, map);
            }
        }
        int lastEnd = -1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            // System.out.println(entry.getKey()+" "+entry.getValue());
            if(lastEnd != -1)
            {
                freeTimes.add(new Interval(lastEnd, entry.getKey()));
            }
            lastEnd = entry.getValue();
        }
        return freeTimes;
    }
    private void addNewInterval(Interval interval, TreeMap<Integer,Integer> map)
    {
        int start = interval.start;
        int end = interval.end;
        while(true)
        {
            var floor = map.floorEntry(end);
            if(floor == null || floor.getValue() < start)
            {
                break;
            }
            start = Math.min(start, floor.getKey());
            end = Math.max(end, floor.getValue());
            map.remove(floor.getKey());
        }
        map.put(start, end);
    }
}