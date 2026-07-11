class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> {
            return a.length() - b.length();
        });
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(checkValidPred(words[j], words[i]))
                {
                    if(dp[j] + 1 > dp[i])
                    {
                        dp[i] = dp[j] + 1;
                    }
                    System.out.println(dp[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }
    private boolean checkValidPred(String a, String b)
    {
        if(a.length() + 1 != b.length())
        {
            return false;
        }
        int skips = 0;
        int i=0;
        int j=0;
        while(i < a.length())
        {
            if(a.charAt(i) != b.charAt(j))
            {
                skips++;
                if(skips == 2)
                {
                    return false;
                }
                j++;
            }
            else
            {
                i++;
                j++;
            }
        }
        return true;
    }
}