class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum < 0)
            {
                sum = 0;
            }
        }
        int min = 0;
        sum = 0;
        for(int i=0; i<nums.length; i++)
        {
            sum += nums[i];
            min = Math.min(min,sum);
            if(sum > 0)
            {
                sum = 0;
            }
        }
        return Math.max(max, Math.abs(min));
    }
}