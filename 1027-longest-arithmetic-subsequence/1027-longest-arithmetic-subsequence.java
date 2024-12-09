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
                if(dp[j].containsKey(diff))
                {
                    int current = dp[j].get(diff) + 1;
                    if(current > ans)
                    {
                        ans = current;
                    }
                    if(current > dp[i].getOrDefault(diff, 0))
                    {
                        dp[i].put(diff, current);
                    }
                }
                else
                {
                    dp[i].put(diff, 2);
                }
            }
        }
        return ans;
    }
}