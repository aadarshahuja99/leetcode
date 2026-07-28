class Solution {
    // One more solution in addition to this one: BS on answer 0 to k-1 query index. For each index, perform a line sweep on the array to check if all elements can be zero in check function.
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, carriedOperations = 0, k = 0;
        int[] differenceArray = new int[n + 1];
        int q = queries.length;
        // Note that we can not sort queries as order matters here
        // Iterate through nums
        for (int index = 0; index < n; index++) {
            // Iterate through queries while current index of nums cannot equal zero
            while (carriedOperations + differenceArray[index] < nums[index]) {
                // Zero array isn't formed after all queries are processed
                if (k == q) {
                    return -1;
                }
                int left = queries[k][0];
                int right = queries[k][1];
                int val = queries[k][2];
                // Process start and end of range
                if (right >= index) {
                    differenceArray[Math.max(left, index)] += val;
                    differenceArray[right + 1] -= val;
                }
                k++;
            }
            // Update prefix carriedOperations at current index so that it can be used by the next index
            carriedOperations += differenceArray[index];
        }
        return k;
    }
}