class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] cache = new int[n+1];
        for(int i=n-1; i>=0; i--)
        {
            int floor1Day = getFloorIndex(days[i], days);
            int floor7Day = getFloorIndex(days[i] + 6, days);
            int floor30Day = getFloorIndex(days[i] + 29, days);
            int current = costs[0] + cache[floor1Day+1];
            if(floor7Day != -1)
            {
                current = Math.min(current, costs[1] + cache[floor7Day+1]);
            }
            if(floor30Day != -1)
            {
                current = Math.min(current, costs[2] + cache[floor30Day+1]);
            }
            cache[i] = current;
        }
        return cache[0];
        // return getAns(0, costs, days, cache);
    }
    private int getFloorIndex(int val, int[] days)
    {
        int s = 0;
        int ans = -1;
        int e = days.length-1;
        while(s <= e)
        {
            int m = s + (e-s)/2;
            if(days[m] <= val)
            {
                ans = m;
                s = m+1;
            }
            else
            {
                e = m-1;
            }
        }
        return ans;
    }
}