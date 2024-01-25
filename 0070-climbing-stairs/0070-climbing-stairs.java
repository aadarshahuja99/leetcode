class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return getWays(0,n,dp);
    }
    private int getWays(int current, int n, int[] dp)
    {
        if(current == n)
        {
            return 1;
        }
        if(current > n)
        {
            return 0;
        }
        if(dp[current] != -1)
        {
            return dp[current];
        }
        dp[current] = getWays(current+1,n,dp) + getWays(current+2,n,dp);
        return dp[current];
    }
}