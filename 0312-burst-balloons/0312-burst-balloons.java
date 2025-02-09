class Solution {
    public int maxCoins(int[] nums) {
        int[] updated = new int[nums.length+2];
        updated[0] = 1;
        updated[nums.length+1] = 1;
        for(int i=1; i<=nums.length; i++)
        {
            updated[i] = nums[i-1];
        }
        int[][] dp = new int[updated.length][updated.length];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return countMaximumCoins(1,updated.length-2,updated,dp);
    }
    private int countMaximumCoins(int i, int j, int[] nums, int[][] dp)
    {
        if(i > j)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int maxCoins = 0;
        for(int k=i; k<=j; k++)
        {
            // the second argument contains the computation for the last balloon that will be busted
            maxCoins = Math.max(maxCoins, countMaximumCoins(i,k-1,nums,dp) + countMaximumCoins(k+1,j,nums,dp) + nums[i-1]*nums[k]*nums[j+1]);
        }
        return dp[i][j] = maxCoins;
    }
}