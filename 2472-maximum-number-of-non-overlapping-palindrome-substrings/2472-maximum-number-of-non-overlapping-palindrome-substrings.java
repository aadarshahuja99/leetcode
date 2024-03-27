class Solution {
    public int maxPalindromes(String s, int k) {
        // 1. similar to longest palindromic substring. Create a table for sub-string lengths 1 and 2. From length 3 onwards run nested loops
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for(int i=0;i <n; i++)
        {
            isPalindrome[i][i] = true;
        }
        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                isPalindrome[i][i+1] = true;
            }
        }
        for(int length = 3; length<=n; length++)
        {
            for(int i=0; i<=n-length; i++)
            {
                isPalindrome[i][i+length-1] = s.charAt(i) == s.charAt(i+length-1) && isPalindrome[i+1][i+length-2];
            }
        }
        int[][] dp = new int[n][n];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getAns(0,k-1,isPalindrome,k,n,dp);
    }
    private int getAns(int i, int j, boolean[][] isPalindrome, int k, int n, int[][] dp)
    {
        if(j >= n)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int notTake = getAns(i,j+1,isPalindrome,k,n,dp);
        int slide = getAns(i+1,j+1,isPalindrome,k,n,dp);
        if(isPalindrome[i][j])
        {
            int take = 1 + getAns(j+1,j+k,isPalindrome,k,n,dp);
            return dp[i][j] = Math.max(take, Math.max(notTake,slide));
        }
        return dp[i][j] = Math.max(notTake,slide);
    }
}