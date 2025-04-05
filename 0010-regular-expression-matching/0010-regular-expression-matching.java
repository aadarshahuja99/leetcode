class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()+1][p.length()+1];
        return getAns(s.length(), p.length(), s, p, dp);
    }
    private Boolean getAns(int i, int j, String s, String p, Boolean[][] dp)
    {
        if(i == 0)
        {
            while(j > 0)
            {
                if(p.charAt(j-1) != '*')
                {
                    return false;
                }
                j-=2;
            }
            return true;
        }
        if(j == 0)
        {
            return false;
        }
        if(dp[i][j] != null)
        {
            return dp[i][j];
        }
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
        {
            return dp[i][j] = getAns(i-1, j-1, s, p, dp);
        }
        else
        {
            if(p.charAt(j-1) == '*' && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'))
            {
                return dp[i][j] = getAns(i-1, j, s, p, dp) || getAns(i, j-1, s, p, dp) || getAns(i, j-2, s, p, dp);
            }
            else if(p.charAt(j-1) == '*')
            {
                return dp[i][j] = getAns(i, j-2, s, p, dp);
            }
        }
        return dp[i][j] = false;
    }
}