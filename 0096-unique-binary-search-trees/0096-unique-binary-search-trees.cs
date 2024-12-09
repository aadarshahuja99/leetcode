public class Solution {
    public int NumTrees(int n) {
        if(n==1)
        {
            return 1;
        }
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++)
        {
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++)
        {
            int s = 0;
            for(int k=1 ;k<=i; k++)
            {
                s += dp[k-1]*dp[i-k];
            }
            dp[i] = s;
        }
        return dp[n];
    }
}