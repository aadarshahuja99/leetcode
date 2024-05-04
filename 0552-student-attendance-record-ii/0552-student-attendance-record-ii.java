class Solution {
    int MOD = 1000000007;
    public int checkRecord(int n) {
        int[][][] dp = new int[n][2][3];
        for(int[][] nestedRow : dp)
        {
            for(int[] row : nestedRow)
            {
                Arrays.fill(row, -1);
            }
        }
        return getWays(0, 0, 0, n, dp);
    }
    private int getWays(int current, int absents, int consecutiveLates, int n, int[][][] dp)
    {
        if(current == n)
        {
            return 1;
        }
        if(dp[current][absents][consecutiveLates] != -1)
        {
            return dp[current][absents][consecutiveLates];
        }
        int present = getWays(current+1, absents, 0, n, dp);
        int late = 0;
        int absent = 0;
        if(absents == 0)
        {
            absent = getWays(current+1, absents+1, 0, n, dp);
        }
        if(consecutiveLates < 2)
        {
            late = getWays(current+1, absents, consecutiveLates+1, n, dp);
        }
        return dp[current][absents][consecutiveLates] = ((present%MOD + absent%MOD)%MOD + late%MOD)%MOD;
    }
}