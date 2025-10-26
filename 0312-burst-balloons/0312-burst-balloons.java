class Solution {
    public int maxCoins(int[] nums) {
        // a variation of select last MCM, we are selecting the element to be bursted at the end of the current segment at each selection, since at that time there will be no next or prev balloons left on either side of the current balloon, we can safely obtain the coins = val[segmentStart-1]*val[segmentEnd+1]*val[currentIndex] from bursting the current balloon at the end of the segment and recursively call the f(i,k-1) and f(i+1,j) methods since each balloon must be bursted individually. There are no operations between balloons to be done (unlike MCM)
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
            int costOfCurrentOperationToBePerformedAtEnd = nums[i-1]*nums[k]*nums[j+1];
            maxCoins = Math.max(maxCoins, countMaximumCoins(i,k-1,nums,dp) + countMaximumCoins(k+1,j,nums,dp) + costOfCurrentOperationToBePerformedAtEnd);
        }
        return dp[i][j] = maxCoins;
    }
}