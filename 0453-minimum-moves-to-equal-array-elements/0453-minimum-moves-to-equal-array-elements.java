class Solution {
    public int minMoves(int[] nums) {
        // jpmc interview question
        if(nums.length == 1)
        {
            return 0;
        }
        // find the min element. Calculate the sum of differences between the min element and the remaining elements
        int min = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(nums[i]<min)
            {
                min = nums[i];
            }
        }
        int ans = 0;
        for(int i=0; i<nums.length; i++)
        {
            ans += nums[i]-min;
        }
        return ans;
    }
}