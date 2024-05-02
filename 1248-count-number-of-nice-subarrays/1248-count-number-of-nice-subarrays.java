class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
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
            if(oddCount == k)
            {
                // we have a candidate
                int currentCount = 0;
                while(oddCount == k)
                {
                    currentCount++;
                    if(nums[start]%2 == 1)
                    {
                        oddCount--;
                    }
                    start++;
                }
                ans += currentCount;
                while(end < n && nums[end]%2 != 1)
                {
                    end++;
                    ans += currentCount;
                }
            }
        }
        if(oddCount == k)
        {
            // we have a candidate
            int currentCount = 0;
            while(oddCount == k)
            {
                currentCount++;
                if(nums[start]%2 == 1)
                {
                    oddCount--;
                }
                start++;
            }
            ans += currentCount;
        }
        return ans;
    }
}