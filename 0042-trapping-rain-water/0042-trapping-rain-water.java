class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int maxSoFar = nums[0];
        int[] rightMax = new int[n];
        rightMax[n-1] = nums[n-1];
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=n-2; i>=0; i--)
        {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }
        for(int i=1; i<n-1; i++)
        {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            int limit = Math.min(rightMax[i], maxSoFar);
            if(limit <= nums[i])
            {
                continue;
            }
            ans += limit - nums[i];
        }
        return ans;
    }
}