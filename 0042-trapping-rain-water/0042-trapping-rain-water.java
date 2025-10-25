class Solution {
    public int trap(int[] nums) {
        // intuitive O(N) space solution
        int n = nums.length;
        int maxSoFarFromLeft = nums[0];
        int[] rightMax = new int[n];
        rightMax[n-1] = 0;
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=n-2; i>=0; i--)
        {
            rightMax[i] = Math.max(rightMax[i+1], nums[i+1]);
        }
        for(int i=1; i<n-1; i++)
        {
            int limit = Math.min(rightMax[i], maxSoFarFromLeft);
            if(limit > nums[i])
            {
                ans += limit - nums[i];
            }
            maxSoFarFromLeft = Math.max(maxSoFarFromLeft, nums[i]);
        }
        return ans;
    }
}
