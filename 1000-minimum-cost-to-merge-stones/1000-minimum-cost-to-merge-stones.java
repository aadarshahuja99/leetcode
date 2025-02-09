class Solution {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        int[] p = new int[n];
        p[0] = stones[0];
        for(int i=1; i<n; i++)
        {
            p[i] = p[i-1] + stones[i];
        }
        int[][][] dp = new int[n][n][K+1];
        for(int[][] nr : dp)
        {
            for(int[] r : nr)
            {
                Arrays.fill(r, -1);
            }
        }
        int ans = getAns(0, n-1, 1, K, p, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int getAns(int st, int end, int piles, int K, int[] pre, int[][][] dp)
    {
        if(st == end && piles == 1)
        {
            return 0;
        }
        if(st == end)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[st][end][piles] != -1)
        {
            return dp[st][end][piles];
        }
        if(piles == 1)
        {
            int val = getAns(st, end, K, K, pre, dp);
            if(val == Integer.MAX_VALUE)
            {
                return dp[st][end][piles] = Integer.MAX_VALUE;
            }
            return dp[st][end][piles] = val + (st == 0 ? pre[end] : pre[end] - pre[st-1]);
        }
        else
        {
            int min = Integer.MAX_VALUE;
            for(int i=st; i<end; i++)
            {
                int first = getAns(st, i, piles-1, K, pre, dp);
                int other = getAns(i+1, end, 1, K, pre, dp);
                if(first == Integer.MAX_VALUE || other == Integer.MAX_VALUE)
                {
                    continue;
                }
                min = Math.min(min, first + other);
            }
            return dp[st][end][piles] = min;
        }
    }
}