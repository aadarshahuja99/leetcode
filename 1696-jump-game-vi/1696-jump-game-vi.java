class Solution {
    public int maxResult(int[] nums, int k) {
        // traditional dp will give TLE. Use Monotonic queue to reduce time complexity. Similar to constrained subsequence sum
        int n = nums.length;
        int[] dp = new int[n];
        LinkedList<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            int max = deque.isEmpty() ? 0 : dp[deque.peekFirst()];
            dp[i] = nums[i] + max;
            while(!deque.isEmpty() && dp[deque.peekLast()] <= dp[i])
            {
                deque.removeLast();
            }
            deque.addLast(i);
            if(i - deque.peekFirst() == k)
            {
                deque.removeFirst();
            }
        }
        return dp[n-1];
    }
}