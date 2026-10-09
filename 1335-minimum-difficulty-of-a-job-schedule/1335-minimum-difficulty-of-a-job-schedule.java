class Solution {
    public int minDifficulty(int[] nums, int d) {
        if(d > nums.length)
        {
            return -1;
        }
        int n = nums.length;
        int[][] dp = new int[n+1][d+1];
        for(int j=1; j<=d; j++)
        {
            dp[n][j] = Integer.MAX_VALUE;
        }
        for(int i=0; i<n; i++)
        {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for(int i=n-1; i>=0; i--)
        {
            for(int j=1; j<=d; j++)
            {
                int max = 0;
                int current = Integer.MAX_VALUE;
                for(int k=i; k<n; k++)
                {
                    max = Math.max(nums[k], max);
                    int next = dp[k+1][j-1];
                    if(next == Integer.MAX_VALUE)
                    {
                        continue;
                    }
                    current = Math.min(current, max + next);
                }
                dp[i][j] = current;
            }
        }
        return dp[0][d];
        // return getAns(0,d,jobDifficulty,dp);
    }
    private int getAns(int current, int d, int[] nums, int[][] dp)
    {
        if(current == nums.length)
        {
            if(d > 0)
            {
                return 10001;
            }
            return 0;
        }
        if(d==0)
        {
            return 100001;
        }
        if(dp[current][d] != -1)
        {
            return dp[current][d];
        }
        int currentMax = nums[current];
        int ans = 10001;
        for(int i=current; i<nums.length; i++)
        {
            currentMax = Math.max(currentMax, nums[i]);
            ans = Math.min(currentMax + getAns(i+1,d-1,nums,dp), ans);
        }
        return (dp[current][d] = ans);
    }
}