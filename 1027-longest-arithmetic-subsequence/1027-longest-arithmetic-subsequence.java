class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer>[] dp = new HashMap[n];
        for(int i=0; i<n; i++)
        {
            dp[i] = new HashMap<>();
        }
        int ans = 2;
        dp[1].put(nums[1] - nums[0], 2);
        for(int i=2; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                int diff = nums[i] - nums[j];
                int current = Math.max(dp[j].getOrDefault(diff, 0) + 1, 2);
                if(current > dp[i].getOrDefault(diff, 0))
                {
                    dp[i].put(diff, current);
                }
                ans = Math.max(dp[i].get(diff), ans);
            }
        }
        return ans;
    }
}