class Solution {
    public int maxArea(int[] nums) {
        int ans = 0;
        int l = 0;
        int n = nums.length;
        int r = n-1;
        while(l < r)
        {
            ans = Math.max(ans, (r - l)*Math.min(nums[l], nums[r]));
            if(nums[l] > nums[r])
            {
                r--;
            }
            else
            {
                l++;
            }
        }
        return ans;
    }
}