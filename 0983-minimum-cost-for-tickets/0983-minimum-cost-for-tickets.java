class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] cache = new int[days.length];
        Arrays.fill(cache, -1);
        return getAns(0, costs, days, cache);
    }
    private int getAns(int current, int[] costs, int[] days, int[] cache)
    {
        if(current == days.length)
        {
            return 0;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<3; i++)
        {
            int floor = getCeil(days, days[current] + getDays(i));
            if(floor > current)
            {
                int val = getAns(floor, costs, days, cache);
                if(val == Integer.MAX_VALUE)
                {
                    continue;
                }
                ans = Math.min(ans, costs[i] + val);
            }
        }
        return cache[current] = ans;
    }
    private int getDays(int idx)
    {
        if(idx == 0)
        {
            return 1;
        }
        if(idx == 1)
        {
            return 7;
        }
        return 30;
    }
    private int getCeil(int[] nums, int t)
    {
        int s = 0;
        int ans = -1;
        int e = nums.length-1;
        while(s <= e)
        {
            int m = s + (e - s)/2;
            if(nums[m] >= t)
            {
                ans = m;
                e = m-1;
            }
            else
            {
                s = m+1;
            }
        }
        return ans == -1 ? nums.length : ans;
    }
}