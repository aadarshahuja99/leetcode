class Solution {
    public int makePrefSumNonNegative(int[] nums) {
        int ans = 0;
        long sum = 0;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++)
        {
            sum += nums[i]*1l;
            pq.add(nums[i]);
            if(sum < 0)
            {
                sum -= pq.poll();
                ans++;
            }
        }
        return ans;
    }
}