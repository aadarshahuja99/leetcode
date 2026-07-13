class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        int n = nums.length;
        HashMap<Integer,Integer> dp = new HashMap<>();
        int ans = 1;
        for(int i=0; i<n; i++)
        {
            int prev = nums[i] - difference;
            if(dp.containsKey(prev))
            {
                int current = dp.get(prev) + 1;
                dp.put(nums[i], Math.max(dp.getOrDefault(nums[i], 1), current));
                ans = Math.max(ans, dp.get(nums[i]));
            }
            else if(!dp.containsKey(nums[i]))
            {
                dp.put(nums[i], 1);
            }
        }
        return ans;
    }
}