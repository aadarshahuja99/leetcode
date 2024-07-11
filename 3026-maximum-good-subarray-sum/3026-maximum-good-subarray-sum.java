class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Long> map = new HashMap<>();
        int idx = 0;
        long ans = Long.MIN_VALUE;
        long[] pre = new long[nums.length];
        for(int num : nums)
        {
            pre[idx] = idx > 0 ? pre[idx-1]*1l + num*1l : num*1l;
            if(map.containsKey(num - k))
            {
                ans = (long)Math.max(ans, pre[idx]*1l - map.get(num - k)*1l + num*1l - k*1l);
            }
            if(map.containsKey(num + k))
            {
                ans = (long)Math.max(ans, pre[idx]*1l - map.get(num + k)*1l + num*1l + k*1l);
            }
            if(map.containsKey(num))
            {
                if(pre[idx] < map.get(num))
                {
                    map.put(num, pre[idx]);
                }
            }
            else
            {
                map.put(num, pre[idx]);
            }
            idx++;
        }
        return ans == Long.MIN_VALUE ? 0 : ans;
    }
}