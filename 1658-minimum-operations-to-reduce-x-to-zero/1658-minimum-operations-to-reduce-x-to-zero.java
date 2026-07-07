class Solution {
    public int minOperations(int[] nums, int x) {
        // sw (only works for positive elements: max length of subarray with sum = total - x
        // in case of negative elements present in the array, use hashmap based approach to find the longest subarray with sum = total - x;
        int ans = -1;
        int maxLength = 0;
        int n = nums.length;
        int j=0, i=0;
        int windowSum = 0;
        int total = 0;
        for(int num : nums)
        {
            total += num;
        }
        if(x == total)
        {
            return n;
        }
        while(j < n)
        {
            // consume jth guy
            windowSum += nums[j];
            j++;
            while(windowSum > total - x && i < j)
            {
                windowSum -= nums[i];
                i++;
            }
            if(windowSum == total - x)
            {
                maxLength = Math.max(j-i, maxLength);
            }
        }
        if(maxLength == 0)
        {
            return -1;
        }
        return n - maxLength;
    }
}