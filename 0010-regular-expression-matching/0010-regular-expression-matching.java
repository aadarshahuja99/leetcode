class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] cache = new boolean[m+1][n+1];
        cache[0][0] = true;
        for(int j=2; j<=n; j+=2)
        {
            cache[0][j] = cache[0][j-2] && p.charAt(j-1) == '*';
        }
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
                {
                    cache[i][j] = cache[i-1][j-1];
                }
                else
                {
                    if(p.charAt(j-1) == '*' && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'))
                    {
                        // 1st cache[i-1][j] means at least one match with the j-2 guy and i-1 guy so we only move i pointer. 2nd read means 0 match with the j-2 guy and we skip the j-2 guy
                        cache[i][j] = cache[i-1][j] || cache[i][j-2];
                    }
                    else if(p.charAt(j-1) == '*')
                    {
                        // since s[i-1] != p[j-2] there is no other choice but to skip the (j-2)th guy
                        cache[i][j] = cache[i][j-2];
                    }
                }
            }
        }
        return cache[m][n];
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
                // 1st call tries for at least 1 matching, second call is for zero matching
                return dp[i][j] = getAns(i-1, j, s, p, dp) || getAns(i, j-2, s, p, dp);
            }
            else if(p.charAt(j-1) == '*')
            {
                // zero matching call
                return dp[i][j] = getAns(i, j-2, s, p, dp);
            }
        }
        return dp[i][j] = false;
    }
}