class Solution {
    public int subarraySum(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i=0; i<n; i++)
        {
            int s = Math.max(0, i - nums[i]);
            ans += pre[i] - pre[s] + nums[s];
        }
        return ans;
    }
}