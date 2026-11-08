class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        return slidingWindowAtMost(nums, k) - slidingWindowAtMost(nums, k-1);
    }
    // Helper function to count the number of subarrays with at most k sum.
    private int slidingWindowAtMost(int[] nums, int k) {
        if(k < 0)
        {
            return 0;
        }
        // To store the occurrences of each element.
        int left = 0, totalCount = 0;
        int sum = 0;
        int n = nums.length;
        int right = 0;
        // Right pointer of the sliding window iterates through the array.
        while(right < n) {
            // consume right
            sum += nums[right];
            right++;
            while (left < n && sum > k) {
                sum -= nums[left];
                left++;
            }
            // Update the total count by adding the length of the current subarray.
            totalCount += (right - left);
        }
        return totalCount;
    }
}