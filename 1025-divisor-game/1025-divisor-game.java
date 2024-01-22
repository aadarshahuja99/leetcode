class Solution {
    public boolean divisorGame(int n) {
        if(n==1)
        {
            return false;
        }
        int[][] dp = new int[n+1][2];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        int ans = check(n,1,dp);
        return ans > 0;
    }
    private int check(int current, int isAlice, int[][] dp)
    {
        if(current==1)
        {
            return 0;
        }
        if(dp[current][isAlice] != -1)
        {
            return dp[current][isAlice];
        }
        if(isAlice == 1)
        {
            int max = 1 + check(current-1,0,dp);
            for(int i=2; i<current; i++)
            {
                if(current%i==0)
                {
                    max =  Math.max(max, 1 + check(current-i,0,dp));
                }
            }
            dp[current][isAlice] = max;
            return max;
        }
        else
        {
            int min = -1 + check(current-1,1,dp);
            for(int i=2; i<current; i++)
            {
                if(current%i==0)
                {
                    min = Math.min(min, -1 + check(current-i,1,dp));
                }
            }
            dp[current][isAlice] = min;
            return min;
        }
    }
}