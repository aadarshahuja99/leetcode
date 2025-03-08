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
        int maxSubsetSum = getAns(0,0,sum/2,stones,dp);
        return sum - 2*maxSubsetSum;
    }
    private int getAns(int current, int sum, int target, int[] stones, int[][] dp)
    {
        if(sum == target)
        {
            return sum;
        }
        if(current == stones.length)
        {
            return sum;
        }
        if(dp[current][sum] != -1)
        {
            return dp[current][sum];
        }
        if(sum + stones[current] <= target)
        {
            return (dp[current][sum] = Math.max(getAns(current+1, sum+stones[current], target, stones, dp), getAns(current+1, sum, target, stones, dp)));
        }
        return (dp[current][sum] = getAns(current+1, sum, target, stones, dp));
    }
}