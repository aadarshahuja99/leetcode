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
            if(end - start < k)
            {
                while(deque.size() > 0 && deque.peekLast() < nums[end])
                {
                    deque.removeLast();
                }
                deque.addLast(nums[end]);
                end++;
            }
            else
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
        ans[idx] = deque.peekFirst();
        return ans;
    }
}