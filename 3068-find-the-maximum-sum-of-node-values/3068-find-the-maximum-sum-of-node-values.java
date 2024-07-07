class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[][] cache = new long[nums.length][2];
        for(long[] row : cache)
        {
            Arrays.fill(row, -1l);
        }
        return getAns(0, 1, k, nums, cache);
    }
    private long getAns(int current, int isEven, int k, int[] nums, long[][] cache)
    {
        if(current == nums.length)
        {
            if(isEven == 0)
            {
                return Long.MIN_VALUE;
            }
            return 0l;
        }
        if(cache[current][isEven] != -1)
        {
            return cache[current][isEven];
        }
        long take = (nums[current]^k) + getAns(current+1, isEven == 1 ? 0 : 1, k, nums, cache);
        long notTake = (nums[current]) + getAns(current+1, isEven, k, nums, cache);
        // System.out.println(take+" "+notTake+" "+current+" "+isEven+", "+(nums[current]^k)+" "+nums[current]);
        return cache[current][isEven] = Math.max(take, notTake);
    }
}