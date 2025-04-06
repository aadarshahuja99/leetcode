class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int numStates = (int)Math.pow(2, jobs.length);
        int[] sums = new int[numStates];
        for(int i=0; i<sums.length; i++)
        {
            for(int j=0; j<jobs.length; j++)
            {
                if((i&(1<<j)) > 0)
                {
                    sums[i] += jobs[j];
                }
            }
        }
        int[][] dp = new int[k+1][numStates];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(sums.length-1, k, sums, dp);
    }
    private int getAns(int state, int k, int[] sums, int[][] dp)
    {
        if(state == 0)
        {
            return 0;
        }
        if(k == 0)
        {
            return Integer.MAX_VALUE;
        }
        if(dp[k][state] != -1)
        {
            return dp[k][state];
        }
        int currentMinTimeToComplete = Integer.MAX_VALUE;
        for(int i=state; i>=0; i--)
        {
            if((state&(i)) == i)
            {
                currentMinTimeToComplete = Math.min(currentMinTimeToComplete, Math.max(sums[i], getAns(state^i,k-1,sums,dp)));
            }
        }
        return dp[k][state] = currentMinTimeToComplete;
    }
}