class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // using a deque
        LinkedList<long[]> queue = new LinkedList<>();
        int n = nums.length;
        long[] prefixSums = new long[n];
        int ans = n+1;
        for(int i=0; i<n; i++)
        {
            prefixSums[i] = i > 0 ? prefixSums[i-1] + nums[i] : nums[i];
            if(prefixSums[i] >= k)
            {
                ans = Math.min(ans, i+1);
            }
            // The current index i is a better starting point for future subarrays because it comes later (making subarrays shorter) and its prefix sum is smaller (making it easier for future elements to subtract from it and reach k). This step sanitizes the queue
            while(!queue.isEmpty() && queue.getLast()[1] > prefixSums[i])
            {
                queue.removeLast();
            }
            // computing answer
            while(!queue.isEmpty() && (prefixSums[i] - queue.getFirst()[1]) >= k)
            {
                ans = Math.min(ans, i - (int)queue.getFirst()[0]);
                queue.removeFirst();
            }
            queue.addLast(new long[] { i, prefixSums[i] });
        }
        return ans == n+1 ? -1 : ans;
    }
}