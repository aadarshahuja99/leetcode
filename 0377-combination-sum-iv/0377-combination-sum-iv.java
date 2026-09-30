class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1; i<=target; i++)
        {
            int count = 0;
            for(int idx=0; idx<nums.length; idx++)
            {
                if(nums[idx]<=i)
                {
                    count += dp[i-nums[idx]];
                }
            }
            dp[i] = count;
        }
        return dp[target];
    }
    private int getCount(int target, int[] nums)
    {
        if(target == 0)
        {
            return 1;
        }
        int count = 0;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]<=target)
            {
                count += getCount(target-nums[i],nums);
            }
        }
        return count;
    }
}