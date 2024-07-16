class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int state = 0;
        int maxState = (int)Math.pow(2,tasks.length);
        int[] dp1 = new int[maxState];
        Arrays.fill(dp1, -1);
        int[] sums = new int[maxState];
        for(int i=maxState-1; i>0; i--)
        {
            for(int j=0; j<tasks.length; j++)
            {
                if((i&(1<<j)) > 0)
                {
                    sums[i] += tasks[j];
                }
            }
        }
        return getAns(maxState-1, sessionTime, tasks.length, sums, dp1);
    }
    private int getAns(int state, int sessionTime, int n, int[] sums, int[] dp)
    {
        if(state == 0)
        {
            return 0;
        }
        if(dp[state] != -1)
        {
            return dp[state];
        }
        int ans = n+1;
        for(int i=state; i>0; i--)
        {
            if((state&i) == i && sums[i] <= sessionTime)
            {
                ans = Math.min(1 + getAns(state^i, sessionTime, n, sums, dp), ans);
            }
        }
        return (dp[state] = ans);
    }
}