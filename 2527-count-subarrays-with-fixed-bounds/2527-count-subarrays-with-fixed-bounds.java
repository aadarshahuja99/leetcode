class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minPos = -1;
        int maxPos = -1;
        int outOfRange = -1;
        long ans = 0;
        for(int i=0; i<nums.length; i++)
        {
            int current = nums[i];
            if(nums[i] < minK || nums[i] > maxK)
            {
                outOfRange = i;
            }
            if(minK == current)
            {
                minPos = i;
            }
            if(maxK == current)
            {
                maxPos = i;
            }
            int start = Math.min(minPos, maxPos);
            if(start > outOfRange)
            {
                // System.out.println(i+" "+start+" "+outOfRange);
                ans += start - outOfRange;
            }
        }
        return ans;
    }
}