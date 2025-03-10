class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int end = 0;
        int start = 0;
        int ans = 0;
        int n = nums.length;
        while(end < n)
        {
            if(nums[end] == 0)
            {
                zeroCount++;
            }
            end++;
            while(zeroCount > k)
            {
                if(nums[start] == 0)
                {
                    zeroCount--;
                }
                start++;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}