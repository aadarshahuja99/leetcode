class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int length = check(0, s.length()-1, s, dp);
        // System.out.println(length);
        return s.length() - length <= k;
    }
    private int check(int start, int end, String s, int[][] dp)
    {
        if(start == end)
        {
            return 1;
        }
        if(start > end)
        {
            return 0;
        }
        if(dp[start][end] != -1)
        {
            return dp[start][end];
        }
        if(s.charAt(start) != s.charAt(end))
        {
            return dp[start][end] = Math.max(check(start+1, end, s, dp), check(start, end-1, s, dp));
        }
        return dp[start][end] = 2 + check(start+1, end-1, s, dp);
    }
}