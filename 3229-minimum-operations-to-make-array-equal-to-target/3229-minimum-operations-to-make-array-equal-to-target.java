class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        // extension of LC 1526: https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/ 
        // here the direction of change can change from increments to decrements
        // and vice versa can happen
        // Check if the current difference is lesser than the previous difference 
        // and is in the same direction as the previous difference. If so then it can use the previous index's operations. If not then it will need some additional ops. On the other hand, if direction of change is different, then previous guys ops will be of no use
        int directionOfChange = 0;
        int previousDiff = 0;
        long ops = 0l;
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] <= target[i])
            {
                int diff = target[i] - nums[i];
                // increasing direction for current diff
                if(directionOfChange == 1)
                {
                    // if current direction is increasing, try to re-use the last guy's ops
                    ops += Math.max(diff - previousDiff, 0);
                }
                else
                {
                    // start of a new direction
                    directionOfChange = 1;
                    ops += diff;
                }
                previousDiff = diff;
            }
            else
            {
                int diff = nums[i] - target[i];
                // decreasing direction for current diff
                if(directionOfChange == -1)
                {
                    // if current direction is increasing, try to re-use the last guy's ops
                    ops += Math.max(diff - previousDiff, 0);
                }
                else
                {
                    // start of a new direction
                    directionOfChange = -1;
                    ops += diff;
                }
                previousDiff = diff;
            }
        }
        return ops;
    }
}