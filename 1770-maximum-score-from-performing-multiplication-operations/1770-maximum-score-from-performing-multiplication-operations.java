class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp = new int[nums.length][multipliers.length];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0,0,nums,multipliers,dp);
    }
    private int getAns(int i, int j, int[] nums, int[] multipliers, int[][] dp)
    {
        int lastIndex = (nums.length - 1) - (j - i);
        if(j == multipliers.length)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        return dp[i][j] = Math.max(nums[i]*multipliers[j] + getAns(i+1,j+1,nums,multipliers,dp),
        nums[lastIndex]*multipliers[j]+ getAns(i,j+1,nums,multipliers,dp));
    }
}