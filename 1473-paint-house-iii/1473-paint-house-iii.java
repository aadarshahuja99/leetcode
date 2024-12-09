class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int t) {
        int[][][] dp = new int[m][t+1][n+1];
        for(int[][] nr : dp)
        {
            for(int[] r : nr)
            {
                Arrays.fill(r, -1);
            }
        }
        int ans = getAns(0, t, 0, houses, cost, m, n, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int getAns(int current, int t, int last, int[] houses, int[][] cost, int m, int n, int[][][] dp)
    {
        if(current == m)
        {
            return t == 0 ? 0 : Integer.MAX_VALUE;
        }
        if(dp[current][t][last] != -1)
        {
            return dp[current][t][last];
        }
        if(houses[current]  > 0)
        {
            if(houses[current] != last)
            {
                if(t == 0)
                {
                    return dp[current][t][last] = Integer.MAX_VALUE;
                }
                return dp[current][t][last] = getAns(current+1, t-1, houses[current], houses, cost, m, n, dp);
            }
            else
            {
                return dp[current][t][last] = getAns(current+1, t, houses[current], houses, cost, m, n, dp);
            }
        }
        int min = Integer.MAX_VALUE;
        if(last != 0)
        {
            int c = cost[current][last-1];
            int continued = getAns(current+1, t, last, houses, cost, m, n, dp);
            if(continued == Integer.MAX_VALUE)
            {
                min = Integer.MAX_VALUE;
            }
            else
            {
                min = c + continued;
            }
        }
        if(t > 0)
        {
            for(int i=0; i<n; i++)
            {
                if(i == last-1)
                {
                    continue;
                }
                int currentCost = getAns(current+1, t-1, i+1, houses, cost, m, n, dp);
                if(currentCost == Integer.MAX_VALUE)
                {
                    continue;
                }
                min = Math.min(min, cost[current][i] + currentCost);
            }
        }
        return dp[current][t][last] = min;
    }
}