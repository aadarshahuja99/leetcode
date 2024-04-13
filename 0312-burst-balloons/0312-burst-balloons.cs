public class Solution {
    public int MaxCoins(int[] nums) {
        if(nums.Length == 1)
        {
            return nums[0];
        }
        int[] newNums = new int[nums.Length+2];
        newNums[0] = 1;
        newNums[nums.Length+1] = 1;
        int[,] dp = new int[newNums.Length, newNums.Length];
        for(int i=0; i<newNums.Length; i++)
        {
            for(int j=0; j<newNums.Length; j++)
            {
                dp[i,j] = -1;
            }
        }
        for(int i=1; i<nums.Length+1; i++)
        {
            newNums[i] = nums[i-1];
        }
        return CalculateScore(newNums,1,newNums.Length-2,dp);
    }
    private int CalculateScore(int[] nums, int i, int j, int[,] dp)
    {
        if(i > j)
        {
            return 0;
        }
        if(dp[i,j] != -1)
        {
            return dp[i,j];
        }
        int maxScore = Int32.MinValue;
        for(int k=i;k<=j;k++)
        {
            int score = nums[i-1]*nums[k]*nums[j+1] + CalculateScore(nums, i, k-1, dp) + CalculateScore(nums, k+1, j, dp);
            maxScore = Math.Max(score, maxScore);
        }
        dp[i,j] = maxScore;
        return maxScore;
    }
}