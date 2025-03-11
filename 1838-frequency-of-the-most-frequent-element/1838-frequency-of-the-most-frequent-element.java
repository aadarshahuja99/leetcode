class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        long total = 0;
        int start = 0;
        int end = 0;
        int n = nums.length;
        int ans = 1;
        while(end < n)
        {
            total += nums[end];
            end++;
            long desired = 1l*(end - start)*nums[end-1];
            long ops = desired - total;
            while(ops > k)
            {
                desired -= nums[end-1];
                total -= nums[start];
                start++;
                ops = desired - total;
            }
            ans = Math.max(ans, end - start);
        }
        return ans;
    }
}