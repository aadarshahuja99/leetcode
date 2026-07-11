class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        // preprocess using the logic used in longest palindromic substring
        int[][] diffPairs = new int[n][n];
        for(int i=0; i<n; i++)
        {
            diffPairs[i][i] = 0;
        }
        for(int i=0; i<n-1; i++)
        {
            diffPairs[i][i+1] = s.charAt(i) == s.charAt(i+1) ? 0 : 1;
        }
        for(int length=3; length<=n; length++)
        {
            for(int i=0; i<=n-length; i++)
            {
                diffPairs[i][i+length-1] = s.charAt(i) == s.charAt(i+length-1) ? diffPairs[i+1][i+length-2] : diffPairs[i+1][i+length-2] + 1;
            }
        }
        int[][] dp = new int[n][k+1];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(0,k,diffPairs,dp);
    }
    private int getAns(int current, int k, int[][] diffPairs, int[][] dp)
    {
        if(current == diffPairs.length)
        {
            if(k == 0)
            {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(k == 1)
        {
            return diffPairs[current][diffPairs.length-1];
        }
        if(dp[current][k] != -1)
        {
            return dp[current][k];
        }
        int ans = diffPairs.length;
        for(int i=current; i<diffPairs.length; i++)
        {
            int next = getAns(i+1,k-1,diffPairs,dp);
            if(next == Integer.MAX_VALUE)
            {
                continue;
            }
            ans = Math.min(diffPairs[current][i] + next, ans);
        }
        return dp[current][k] = ans;
    }
}