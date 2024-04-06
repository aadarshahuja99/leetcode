class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        /*
            approaches:
            1. Find out the min subarray sum and subtract it from the total aray sum
            2. create a new array that contains 2 instances of the given array. apply sliding window
        */
        int minSoFar = 0;
        int min = Integer.MAX_VALUE;
        int maxSoFar = 0;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for(int i=0; i<nums.length; i++)
        {
            minSoFar += nums[i];
            min = Math.min(minSoFar, min);
            if(minSoFar > 0)
            {
                minSoFar = 0;
            }
            maxSoFar += nums[i];
            max = Math.max(maxSoFar, max);
            if(maxSoFar < 0)
            {
                maxSoFar = 0;
            }
            total += nums[i];
        }
        if(max < 0)
        {
            return max;
        }
        return Math.max(max, total - min);
    }
}