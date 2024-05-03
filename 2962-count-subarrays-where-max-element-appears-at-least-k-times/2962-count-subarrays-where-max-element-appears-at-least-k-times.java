class Solution {
    public long countSubarrays(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int max = 0;
        for(int num : nums)
        {
            max = Math.max(max, num);
        }
        int n = nums.length;
        int countMax = 0;
        long ans = 0;
        while(end < n)
        {
            if(countMax < k)
            {
                if(nums[end] == max)
                {
                    countMax++;
                }
                end++;
            }
            else if(countMax == k)
            {
                int currentCount = 0;
                while(countMax == k)
                {
                    currentCount++;
                    if(nums[start] == max)
                    {
                        countMax--;
                    }
                    start++;
                }
                ans += currentCount*1L*(n - end + 1);
                // System.out.println((currentCount*(n - end))+" for i: "+start);
            }
        }

        if(countMax == k)
        {
            int currentCount = 0;
            while(countMax == k)
            {
                currentCount++;
                if(nums[start] == max)
                {
                    countMax--;
                }
                start++;
            }
            ans += currentCount;
        }
        return ans;
    }
}