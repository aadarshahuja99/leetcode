class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start < nums.length-1 && nums[start] <= nums[start+1])
        {
            start++;
        }
        if(start == nums.length-1)
        {
            return 0;
        }
        while(end > 0 && nums[end] >= nums[end-1])
        {
            end--;
        }
        if(end == 0)
        {
            return 0;
        }
        int it = start;
        int rangeMax = Integer.MIN_VALUE;
        int rangeMin = Integer.MAX_VALUE;
        while(it <= end)
        {
            rangeMax = Math.max(rangeMax,nums[it]);
            rangeMin = Math.min(rangeMin,nums[it]);
            it++;
        }
        for(int idx=start; idx>=0; idx--)
        {
            if(nums[idx] > rangeMin)
            {
                start = idx;
            }
        }
        for(int j=end+1; j<nums.length; j++)
        {
            if(nums[j] < rangeMax)
            {
                end = j;
            }
        }
        return end-start+1;
    }
}