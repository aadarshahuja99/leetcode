class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            int current = 1;
            int ans = Integer.MAX_VALUE;
            while(current*current <= i)
            {
                ans = Math.min(ans, 1+dp[i-current*current]);
                current = current+1;
            }
            dp[i] = ans;
        }
        return dp[n];
    }
    // recursive solution for future reference
    private int getMinSquares(int n)
    {
        if(n==0)
        {
            return 0;
        }
        int current = 1;
        int ans = Integer.MAX_VALUE;
        while(current*current <= n)
        {
            ans = Math.min(ans, 1+getMinSquares(n-current*current));
            current = current+1;
        }
        return ans;
    }
}