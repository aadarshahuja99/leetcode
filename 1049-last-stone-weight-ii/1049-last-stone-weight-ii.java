class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int s : stones)
        {
            sum += s;
        }
        int[][] dp = new int[stones.length][(sum/2)+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int maxSubsetSum = getAns(0,sum/2,stones,dp);
        return sum - 2*maxSubsetSum;
    }
    private int getAns(int current, int target, int[] stones, int[][] dp)
    {
        if(target == 0)
        {
            return 0;
        }
        if(current == stones.length)
        {
            return 0;
        }
        if(dp[current][target] != -1)
        {
            return dp[current][target];
        }
        int proceed = getAns(current+1, target, stones, dp);
        if(stones[current] <= target)
        {
            return (dp[current][target] = Math.max(stones[current] + getAns(current+1, target - stones[current], stones, dp), proceed));
        }
        return (dp[current][target] = proceed);
    }
}