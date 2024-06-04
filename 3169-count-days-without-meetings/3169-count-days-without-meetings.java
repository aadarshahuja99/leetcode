class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> {
            return a[0] - b[0];
        });
        TreeMap<Integer,Integer> meets = new TreeMap<>();
        for(int[] meet : meetings)
        {
            insertMeeting(meet, meets);
        }
        int lastEnd = 1;
        int ans = 0;
        for(var entry : meets.entrySet())
        {
            // System.out.println(entry.getKey()+" "+entry.getValue()+" "+lastEnd);
            ans += entry.getKey() - lastEnd;
            lastEnd = entry.getValue();
        }
        if(lastEnd <= days)
        {
            ans += days - lastEnd + 1;
        }
        return ans;
    }
    private void insertMeeting(int[] meet, TreeMap<Integer,Integer> map)
    {
        int start = meet[0];
        int end = meet[1] + 1;
        while(true)
        {
            var floor = map.floorEntry(end);
            if(floor == null || floor.getValue() < start)
            {
                break;
            }
            start = Math.min(floor.getKey(), start);
            end = Math.max(floor.getValue(), end);
            map.remove(floor.getKey());
        }
        map.put(start, end);
    }
}