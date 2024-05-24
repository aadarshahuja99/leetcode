class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        if(n == 1)
        {
            return 1;
        }
        int[] pre = new int[n];
        int[] post = new int[n];
        for(int i=1; i<n; i++)
        {
            if(nums[i-1] == 1)
            {
                pre[i] = pre[i-1] + 1;
            }
        }
        int ans = 0;
        for(int i=n-1; i>=0; i--)
        {
            if(i+1 < n && nums[i+1] == 1)
            {
                post[i] = post[i+1] + 1;
            }
            ans = Math.max(ans, pre[i] + post[i] + 1);
        }
        return ans;
    }
}