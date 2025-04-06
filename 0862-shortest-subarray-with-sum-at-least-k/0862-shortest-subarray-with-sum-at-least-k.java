class Solution {
    public int shortestSubarray(int[] nums, int k) {
        // using a deque
        LinkedList<long[]> list = new LinkedList<>();
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
            while(!list.isEmpty() && list.getLast()[1] > prefixSums[i])
            {
                list.removeLast();
            }
            while(!list.isEmpty() && (prefixSums[i] - list.getFirst()[1]) >= k)
            {
                ans = Math.min(ans, i - (int)list.getFirst()[0]);
                list.removeFirst();
            }
            list.addLast(new long[] { i, prefixSums[i] });
        }
        return ans == n+1 ? -1 : ans;
    }
}