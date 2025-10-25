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
        boolean[][] cache = new boolean[nums.length+1][(s/2) + 1];
        for(int i=0; i<=nums.length; i++)
        {
            cache[i][0] = true;
        }
        for(int current = nums.length-1; current >= 0; current--)
        {
            for(int t = 1; t <= s/2; t++)
            {
                var notTake = cache[current+1][t];
                if(nums[current] <= t)
                {
                    var take = cache[current+1][t-nums[current]];
                    cache[current][t] = take || notTake;
                }
                else
                {
                    cache[current][t] = notTake;
                }
            }
        }
        return cache[0][s/2];
        // return getAns(0, s/2, nums, cache);
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