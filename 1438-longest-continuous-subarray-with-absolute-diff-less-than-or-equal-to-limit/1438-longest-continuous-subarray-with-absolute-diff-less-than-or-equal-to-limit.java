class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        Deque<Integer> maxQueue = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 1;
        // for the current subarray, calculate its maximum and minimum using queue
        while(j < n)
        {
            while(minQueue.size() > 0 && minQueue.peekLast() > nums[j])
            {
                minQueue.pollLast();
            }
            minQueue.addLast(nums[j]);

            while(maxQueue.size() > 0 && maxQueue.peekLast() < nums[j])
            {
                maxQueue.pollLast();
            }
            maxQueue.addLast(nums[j]);

            j++;
            
            while(maxQueue.peekFirst() - minQueue.peekFirst() > limit)
            {
                if(maxQueue.peekFirst() == nums[i])
                {
                    maxQueue.pollFirst();
                }
                if(minQueue.peekFirst() == nums[i])
                {
                    minQueue.pollFirst();
                }
                i++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}