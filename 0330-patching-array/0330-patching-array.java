class Solution {
    public int minPatches(int[] nums, int n) {
        long maxCovered = 0;
        int idx = 0;
        int count = 0;
        while(maxCovered < n)
        {
            long missing = maxCovered+1l;
            if(idx < nums.length && nums[idx] <= missing)
            {
                maxCovered += nums[idx];
                idx++;
            }
            else
            {
                count++;
                maxCovered += missing;
            }
        }
        return count;
    }
}