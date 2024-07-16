class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] cache = new long[n][2];
        for(long[] row : cache)
        {
            Arrays.fill(row, Long.MIN_VALUE);
        }
        return getAns(0, 0, nums, cache);
    }
    private long getAns(int currentIndex, int lastSign, int[] nums, long[][] cache)
    {
        if(currentIndex == nums.length)
        {
            return 0l;
        }
        if(cache[currentIndex][lastSign] != Long.MIN_VALUE)
        {
            return cache[currentIndex][lastSign];
        }
        long startNew = nums[currentIndex]*1l + getAns(currentIndex+1, 1, nums, cache);
        long continued = Long.MIN_VALUE;
        if(lastSign == 1)
        {
            continued = -nums[currentIndex]*1l + getAns(currentIndex+1, 0, nums, cache);
        }
        return cache[currentIndex][lastSign] = Math.max(startNew, continued);
    }
}