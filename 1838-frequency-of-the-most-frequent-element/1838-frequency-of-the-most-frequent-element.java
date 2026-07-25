class Solution {
    public int maxFrequency(int[] nums, int k) {
        // // Approach 1: Prefix sum + BS + sorting
        // Arrays.sort(nums);
        // int n = nums.length;
        // int[] pre = new int[n];
        // int idx = 0;
        // for(int num : nums)
        // {
        //     pre[idx] = idx > 0 ? pre[idx-1] + num : num;
        //     System.out.println(pre[idx]);
        //     idx++;
        // }
        // int ans = -1;
        // idx = 0;
        // for(int sum : pre)
        // {
        //     ans = Math.max(idx - lowestPossible(sum-k, pre) + 1, ans);
        //     idx++;
        // }
        // return ans;
        // Approach 2: Sorting + Max size Sliding window 
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