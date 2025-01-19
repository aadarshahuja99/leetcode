class Solution {
    public long minCost(int n, int[][] cost) {
        int limit = n%2 == 1 ? n/2 + 1 : n/2;
        long[][][] dp = new long[n][4][4];
        for(long[][] nr : dp)
        {
            for(long[] r : nr)
            {
                Arrays.fill(r, -1);
            }
        }
        return getAns(0, 3, 3, cost, limit, dp);
    }
    private long getAns(int current, int last, int next, int[][] cost, int limit, long[][][] dp)
    {
        if(current == limit)
        {
            return 0;
        }
        int n = cost.length;
        long min = Long.MAX_VALUE;
        if(n%2 == 1 && current == limit-1)
        {
            for(int i=0; i<=2; i++)
            {
                if(i == last || i == next)
                {
                    continue;
                }
                min = Math.min(min, cost[current][i]);
            }
            return min;
        }
        if(dp[current][last][next] != -1)
        {
            return dp[current][last][next];
        }
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(i == j || i == last || j == next)
                {
                    continue;
                }
                min = Math.min(min, cost[current][i] + cost[n-current-1][j] + getAns(current+1, i, j, cost, limit, dp));
            }
        }
        return dp[current][last][next] = min;
    }
}