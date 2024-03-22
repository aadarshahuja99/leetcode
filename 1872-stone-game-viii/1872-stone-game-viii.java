class Solution {
    public int stoneGameVIII(int[] stones) {
        int[] pre = new int[stones.length+1];
        pre[0] = 0;
        for(int i=1; i<=stones.length; i++)
        {
            pre[i] = pre[i-1] + stones[i-1];
        }
        int[][][] dp = new int[stones.length][2][2];
        for(int[][] row : dp)
        {
            for(int[] nestedrow : row)
            {
                Arrays.fill(nestedrow,-1000000001);
            }
        }
        return pre[2] + getAns(2,1,0,pre,stones,dp);
    }
    private int getAns(int current, int isAlice, int isFirst, int[] pre, int[] stones, int[][][] dp)
    {
        if(current == stones.length)
        {
            return 0;
        }
        if(dp[current][isAlice][isFirst] != -1000000001)
        {
            return dp[current][isAlice][isFirst];
        }
        if(isAlice == 1)
        {
            if(isFirst == 1)
            {
                return dp[current][isAlice][isFirst] = pre[current+1] + Math.max(getAns(current+1,1,0,pre,stones,dp), getAns(current+1,0,1,pre,stones,dp));
            }
            else
            {
                int take = Math.max(stones[current] + getAns(current+1,1,0,pre,stones,dp), stones[current] + getAns(current+1,0,1,pre,stones,dp));
                int notTake = getAns(current,0,1,pre,stones,dp);
                return dp[current][isAlice][isFirst] = Math.max(take,notTake);
            }
        }
        else
        {
            if(isFirst == 1)
            {
                return dp[current][isAlice][isFirst] = -1*pre[current+1] + Math.min(getAns(current+1,0,0,pre,stones,dp), getAns(current+1,1,1,pre,stones,dp));
            }
            else
            {
                int take = Math.min(-1*stones[current] + getAns(current+1,0,0,pre,stones,dp), -1*stones[current] + getAns(current+1,1,1,pre,stones,dp));
                int notTake = getAns(current,1,1,pre,stones,dp);
                return dp[current][isAlice][isFirst] = Math.min(take,notTake);
            }
        }
    }
}