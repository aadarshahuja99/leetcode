class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return getAns(0, nums, cache);
    }
    private int getAns(int currentIndex, int[] nums, int[] cache)
    {
        if(currentIndex >= nums.length)
        {
            return 0;
        }
        if(cache[currentIndex] != -1)
        {
            return cache[currentIndex];
        }
        int notTake = getAns(currentIndex+1, nums, cache);
        int take = nums[currentIndex] + getAns(currentIndex+2, nums, cache);
        return cache[currentIndex] = Math.max(take, notTake);
    }
}