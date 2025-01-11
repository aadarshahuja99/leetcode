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
            long desired = 1l*(end - start + 1)*nums[end];
            long ops = desired - total;
            while(ops > k)
            {
                desired -= nums[end];
                total -= nums[start];
                start++;
                ops = desired - total;
            }
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }
}