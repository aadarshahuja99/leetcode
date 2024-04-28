class Solution {
    public long minimumTime(int[] power) {
        int numberOfMonsters = power.length;
        long[] dp = new long[(1<<numberOfMonsters)];
        Arrays.fill(dp, -1);
        return getMinTime(0, 1, power, dp);
    }
    private long getMinTime(int state, int gain, int[] power, long[] dp)
    {
        int numberOfMonsters = power.length;
        if(gain == numberOfMonsters + 1)
        {
            return 0L;
        }
        if(dp[state] != -1)
        {
            return dp[state];
        }
        long ans = 17L*1000000000;
        for(int i=0; i<numberOfMonsters; i++)
        {
            if((state&(1<<i)) == 0)
            {
                long numberOfDaysNeededToKill = (long)Math.ceil((double)power[i]/(double)gain);
                ans = Math.min(ans, numberOfDaysNeededToKill + getMinTime(state|(1<<i), gain+1, power, dp));
            }
        }
        return dp[state] = ans;
    }
}