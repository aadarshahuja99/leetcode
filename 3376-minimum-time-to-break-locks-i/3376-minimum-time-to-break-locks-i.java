class Solution {
    public int findMinimumTime(List<Integer> strength, int K) {
        int[] dp = new int[(int)Math.pow(2, strength.size())];
        Arrays.fill(dp, -1);
        return getMinTime(0, 1, strength, K, dp);
    }
    private int getMinTime(int state, int gain, List<Integer> power, int k, int[] dp)
    {
        int numberOfMonsters = power.size();
        if(state == (1<<numberOfMonsters) - 1)
        {
            return 0;
        }
        if(dp[state] != -1)
        {
            return dp[state];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<numberOfMonsters; i++)
        {
            if((state&(1<<i)) == 0)
            {
                int numberOfDaysNeededToKill = (int)Math.ceil((double)power.get(i)/(double)gain);
                ans = Math.min(ans, numberOfDaysNeededToKill + getMinTime(state|(1<<i), gain+k, power, k, dp));
            }
        }
        return dp[state] = ans;
    }
}