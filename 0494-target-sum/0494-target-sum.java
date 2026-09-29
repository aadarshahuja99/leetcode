class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for(int num : nums)
        {
            s += num;
        }
        int[][] cache = new int[n][2*s + 1];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        int ans = getAns(0, 0, nums, target, cache, s);
        return ans;
    }
    private int getAns(int current, int currentSum, int[] nums, int target, int[][] cache, int sum)
    {
        if(current == nums.length)
        {
            if(currentSum == target)
            {
                return 1;
            }
            return 0;
        }
        if(cache[current][currentSum + sum] != -1)
        {
            return cache[current][currentSum + sum];
        }
        int plus = getAns(current+1, currentSum + nums[current], nums, target, cache, sum);
        int minus = getAns(current+1, currentSum - nums[current], nums, target, cache, sum);
        return cache[current][currentSum + sum] = plus + minus;
    }
}