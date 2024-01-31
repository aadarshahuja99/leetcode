class Solution {
    int max = 1001;
    public int minSteps(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(1,0,n,dp);
    }
    private int getAns(int current, int lastLength, int n, int[][] dp)
    {
        if(current == n)
        {
            return 0;
        }
        if(dp[current][lastLength] != -1)
        {
            return dp[current][lastLength];
        }
        if(lastLength == 0)
        {
            return (dp[current][lastLength] = 1 + getAns(current,1,n,dp));
        }
        if(lastLength + current <= n)
        {
            if(lastLength != current)
            {
                return (dp[current][lastLength] = 1 + Math.min(getAns(current+lastLength,lastLength,n,dp), getAns(current,current,n,dp)));
            }
            return (dp[current][lastLength] = 1 + getAns(current+lastLength,lastLength,n,dp));
        }
        // if no further operations can be done to get to n, return max val indicating that it is not possible to get to n.
        return (dp[current][lastLength] = max);
    }
}