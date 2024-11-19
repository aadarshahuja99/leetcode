class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        long sum = 0l;
        HashMap<Integer,Integer> map = new HashMap<>();
        long ans = 0l;
        while(end < n)
        {
            sum += nums[end]*1l;
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            if(end - start + 1 == k)
            {
                if(map.size() == k)
                {
                    // System.out.println(sum+" "+end+" "+start);
                    ans = Math.max(ans, sum);
                }
                map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
                if(map.get(nums[start]) == 0)
                {
                    map.remove(nums[start]);
                }
                sum -= nums[start]*1l;
                start++;
            }
            end++;
        }
        return ans;
    }
}