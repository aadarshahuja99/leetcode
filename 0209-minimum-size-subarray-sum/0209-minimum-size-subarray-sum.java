class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int j=0;
        int i=0;
        int sum = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        while(j < n)
        {
            // consume jth guy
            sum += nums[j];
            j++;
            // shrink to make window invalid (opposite of max length variable window pattern in this case)
            while(sum >= target)
            {
                ans = Math.min(ans, j-i);
                sum -= nums[i];
                i++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}