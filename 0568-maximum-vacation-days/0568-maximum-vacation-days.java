class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int[][] cache = new int[flights.length][days[0].length];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, days[0].length, flights, days, cache);
    }
    private int getAns(int current, int week, int k, int[][] flights, int[][] days, int[][] cache)
    {
        if(week == k)
        {
            return 0;
        }
        if(cache[current][week] != -1)
        {
            return cache[current][week];
        }
        int ans = days[current][week] + getAns(current, week+1, k, flights, days, cache);
        for(int i=0; i<flights.length; i++)
        {
            if(flights[current][i] != 0)
            {
                ans = Math.max(ans, days[i][week] + getAns(i, week+1, k, flights, days, cache));
            }
        }
        return cache[current][week] = ans;
    }
}