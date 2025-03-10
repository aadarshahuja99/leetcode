class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    private int helper(int[] nums, int k)
    {
        int oddCount = 0;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int ans = 0;
        while(end < n)
        {
            if(nums[end]%2 == 1)
            {
                oddCount++;
            }
            end++;
            while(oddCount > k)
            {
                if(nums[start]%2 == 1)
                {
                    oddCount--;
                }
                start++;
            }
            ans += (end - start);
        }
        return ans;
    }
}