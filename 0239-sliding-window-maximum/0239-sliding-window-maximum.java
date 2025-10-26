class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n-k+1];
        int idx = 0;
        while(end < n)
        {
            // need to maintain a monotonic decreasing deque to store the maximums
            while(deque.size() > 0 && deque.peekLast() < nums[end])
            {
                deque.removeLast();
            }
            deque.addLast(nums[end]);
            end++;
            if(end - start == k)
            {
                ans[idx] = deque.peekFirst();
                if(deque.peekFirst() == nums[start])
                {
                    deque.removeFirst();
                }
                start++;
                idx++;
            }
        }
        return ans;
    }
}