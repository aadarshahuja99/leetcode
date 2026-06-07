class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int max = Integer.MIN_VALUE;
        for(int num : nums)
        {
            currentSum += num;
            if(currentSum > max)
            {
                max = currentSum;
            }
            if(currentSum < 0)
            {
                currentSum = 0;
            }
        }
        return max;
    }
}
