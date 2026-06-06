class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int total = nums[0];
        int[] ans = new int[n];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1]+nums[i-1];
            total += nums[i];
        }
        for(int i=0; i<n; i++)
        {
            ans[i] = Math.abs(pre[i] - (total - pre[i] - nums[i]));
        }
        return ans;
    }
}