class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int num : nums)
        {
            s += num;
        }
        if(s%2 == 1)
        {
            return false;
        }
        Boolean[][] cache = new Boolean[nums.length][(s/2) + 1];
        return getAns(0, s/2, nums, cache);
    }
    private Boolean getAns(int current, int t, int[] nums, Boolean[][] cache)
    {
        if(current == nums.length)
        {
            return t == 0;
        }
        if(t == 0)
        {
            return true;
        }
        if(cache[current][t] != null)
        {
            return cache[current][t];
        }
        var notTake = getAns(current+1, t, nums, cache);
        if(nums[current] <= t)
        {
            var take = getAns(current+1, t-nums[current], nums, cache);
            return cache[current][t] = take || notTake;
        }
        return cache[current][t] = notTake;
    }
}