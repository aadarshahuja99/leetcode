class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
            isPalindrome[i][i] = true;
        }
        for(int i=0; i<n-1; i++)
        {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
        }
        for(int length=3; length<=n; length++)
        {
            for(int i=0; i<=n-length; i++)
            {
                isPalindrome[i][i+length-1] = s.charAt(i) == s.charAt(i+length-1) && isPalindrome[i+1][i+length-2];
            }
        }
        Boolean[][] dp = new Boolean[n][4];
        return getAns(0,3,isPalindrome,dp);
    }
    private boolean getAns(int current, int k, boolean[][] isPalindrome, Boolean[][] dp)
    {
        if(current == isPalindrome.length && k == 0)
        {
            return true;
        }
        if(k == 0 || current == isPalindrome.length)
        {
            return false;
        }
        if(dp[current][k] != null)
        {
            return dp[current][k];
        }
        boolean ans = false;
        for(int i=current; i<isPalindrome.length; i++)
        {
            if(isPalindrome[current][i])
            {
                ans = ans || getAns(i+1,k-1,isPalindrome,dp);
                if(ans)
                {
                    return dp[current][k] = true;
                }
            }
        }
        return dp[current][k] = ans;
    }
}