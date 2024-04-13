class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] dp = new int[cuts.length][cuts.length];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(0,cuts.length-1,cuts,n,dp);
    }
    private int getAns(int i, int j, int[] cuts, int n, int[][] dp)
    {
        if(i > j)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        int currentLengthOfTheStick = 0;
        if(i > 0 && j < cuts.length-1)
        {
            currentLengthOfTheStick = cuts[j+1] - cuts[i-1];
        }
        else if(i > 0)
        {
            currentLengthOfTheStick = n - cuts[i-1];
        }
        else if(j < cuts.length-1)
        {
            currentLengthOfTheStick = cuts[j+1];
        }
        else
        {
            currentLengthOfTheStick = n;
        }
        for(int k=i; k<=j; k++)
        {
            ans = Math.min(ans, currentLengthOfTheStick + getAns(i, k-1, cuts, n, dp) + getAns(k+1, j, cuts, n, dp));
        }
        return dp[i][j] = ans;
    }
}