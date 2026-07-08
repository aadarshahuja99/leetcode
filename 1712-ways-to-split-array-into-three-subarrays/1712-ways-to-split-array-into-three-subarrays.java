class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int ans = 0;
        int modulo = 1_000_000_007;
        
        // j represents the start of the minimum valid mid array
        // k represents the start of the maximum valid mid array
        int j = 1;
        int k = 1;

        // i is the end index of the left subarray
        for (int i = 0; i < n - 2; i++) {
            int leftSum = prefixSum[i];

            // 1. Find the smallest index j such that midSum >= leftSum
            // j must be at least i + 1
            if (j <= i) j = i + 1;
            while (j < n - 1 && prefixSum[j] - prefixSum[i] < leftSum) {
                j++;
            }

            // 2. Find the largest index k such that midSum <= rightSum
            // This is equivalent to finding where rightSum >= midSum
            if (k < j) k = j;
            while (k < n - 1 && prefixSum[n - 1] - prefixSum[k] >= prefixSum[k] - prefixSum[i]) {
                k++;
            }

            // The number of valid positions for the second split point is k - j
            if (j < n - 1 && prefixSum[j] - prefixSum[i] >= leftSum && prefixSum[n - 1] - prefixSum[k - 1] >= prefixSum[k - 1] - prefixSum[i]) {
                ans = ((ans) + (k - j)) % modulo;
            }
        }

        return ans;
    }
}
