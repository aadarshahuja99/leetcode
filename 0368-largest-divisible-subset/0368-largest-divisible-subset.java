class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int[] lasts = new int[n];
        int[] dp = new int[n];
        int ending = 0;
        for(int i=0; i<n; i++)
        {
            lasts[i] = -1;
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(nums[i]%nums[j] == 0)
                {
                    if(dp[j] + 1 > dp[i])
                    {
                        lasts[i] = j;
                        dp[i] = dp[j] + 1;
                    }
                    if(ans < dp[i])
                    {
                        ans = dp[i];
                        ending = i;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        if(ending >= 0)
        {
            while(true)
            {
                list.add(nums[ending]);
                if(lasts[ending] == -1)
                {
                    break;
                }
                ending = lasts[ending];
            }
        }
        Collections.reverse(list);
        return list;
    }
}