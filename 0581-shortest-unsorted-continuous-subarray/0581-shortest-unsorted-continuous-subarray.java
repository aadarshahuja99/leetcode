class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int unsortedStart = 0;
        int unsortedEnd = nums.length-1;
        while(unsortedStart < nums.length-1 && nums[unsortedStart] <= nums[unsortedStart+1])
        {
            unsortedStart++;
        }
        if(unsortedStart == nums.length-1)
        {
            return 0;
        }
        while(unsortedEnd > 0 && nums[unsortedEnd] >= nums[unsortedEnd-1])
        {
            unsortedEnd--;
        }
        if(unsortedEnd == 0)
        {
            return 0;
        }
        int it = unsortedStart;
        int rangeMax = Integer.MIN_VALUE;
        int rangeMin = Integer.MAX_VALUE;
        while(it <= unsortedEnd)
        {
            rangeMax = Math.max(rangeMax,nums[it]);
            rangeMin = Math.min(rangeMin,nums[it]);
            it++;
        }
        for(int idx=unsortedStart; idx>=0; idx--)
        {
            if(nums[idx] > rangeMin)
            {
                unsortedStart = idx;
            }
        }
        for(int idx=unsortedEnd+1; idx<nums.length; idx++)
        {
            if(nums[idx] < rangeMax)
            {
                unsortedEnd = idx;
            }
        }
        return unsortedEnd-unsortedStart+1;
    }
}