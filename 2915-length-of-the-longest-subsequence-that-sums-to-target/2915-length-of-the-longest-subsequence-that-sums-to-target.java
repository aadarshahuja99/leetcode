class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] cache = new int[nums.size()][target+1];
        for(int[] row : cache){
            Arrays.fill(row, -1);
        }
        int length = getAns(0, target, nums, cache);
        if(length < 0)
        {
            return -1;
        }
        return length;
    }
    private int getAns(int current, int target, List<Integer> nums, int[][] cache)
    {
        if(current == nums.size())
        {
            return target == 0 ? 0 : Integer.MIN_VALUE;
        }
        if(target == 0)
        {
            return 0;
        }
        if(cache[current][target] != -1)
        {
            return cache[current][target];
        }
        int num = nums.get(current);
        int notTake = getAns(current+1, target, nums, cache);
        if(num <= target)
        {
            int take = 1 + getAns(current+1, target-num, nums, cache);
            return cache[current][target] = Math.max(take, notTake);
        }
        return cache[current][target]= notTake;
    }
}