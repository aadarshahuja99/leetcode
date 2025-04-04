class Solution {
    public int numSubarrayBoundedMax(int[] nums, int min, int max) {
        return getAllArraysWithMaximumElementLessThanOrEqualTo(max, nums) - getAllArraysWithMaximumElementLessThanOrEqualTo(min-1, nums);
    }
    private int getAllArraysWithMaximumElementLessThanOrEqualTo(int bound, int[] nums)
    {
        int pointer = 0;
        int n = nums.length;
        int currentSegmentLength = 0;
        int ans = 0;
        while(pointer < n)
        {
            if(nums[pointer] <= bound)
            {
                currentSegmentLength++;
            }
            else
            {
                currentSegmentLength = 0;
            }
            ans += currentSegmentLength;
            pointer++;
        }
        return ans;
    }
}