class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] cache = new int[n][2];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        getAns(0, 0, nums, cache);
        return Math.max(cache[0][0], cache[0][1]);
    }
    private int getAns(int current, int wasFirstHouseRobbed, int[] nums, int[][] cache)
    {
        if(current >= nums.length)
        {
            return 0;
        }
        if(cache[current][wasFirstHouseRobbed] != -1)
        {
            return cache[current][wasFirstHouseRobbed];
        }
        if(current == nums.length-1)
        {
            if(wasFirstHouseRobbed == 1)
            {
                return cache[current][wasFirstHouseRobbed] = 0;
            }
            return cache[current][wasFirstHouseRobbed] = nums[current];
        }
        return cache[current][wasFirstHouseRobbed] = Math.max(nums[current] + getAns(current + 2, current == 0 ? 1 : wasFirstHouseRobbed, nums, cache),
        getAns(current + 1, wasFirstHouseRobbed, nums, cache));
    }
}