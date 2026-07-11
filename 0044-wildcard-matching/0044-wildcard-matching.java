class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] cache = new boolean[m+1][n+1];
        cache[0][0] = true;
        for(int j=1; j<=n; j++)
        {
            cache[0][j] = cache[0][j-1] && p.charAt(j-1) == '*';
        }
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                {
                    cache[i][j] = cache[i-1][j-1];
                }
                else if(p.charAt(j-1) == '*')
                {
                    cache[i][j] = cache[i-1][j-1] || cache[i-1][j] || cache[i][j-1];
                }
                else
                {
                    cache[i][j] = false;
                }
            }
        }
        return cache[m][n];
        // return checkForPatternMatch(s.length(), p.length(), s, p, cache);
    }
    private boolean checkForPatternMatch(int currentIndexS, int currentIndexP, String s, String p, Boolean[][] cache)
    {
        if(currentIndexS == 0)
        {
            if(currentIndexP == 0)
            {
                return true;
            }
            while(currentIndexP > 0)
            {
                if(p.charAt(currentIndexP-1) != '*')
                {
                    return false;
                }
                currentIndexP--;
            }
            return true;
        }
        if(currentIndexP == 0)
        {
            return false;
        }
        if(cache[currentIndexS][currentIndexP] != null)
        {
            return cache[currentIndexS][currentIndexP];
        }
        if(s.charAt(currentIndexS-1) == p.charAt(currentIndexP-1) || p.charAt(currentIndexP-1) == '?')
        {
            return cache[currentIndexS][currentIndexP] = checkForPatternMatch(currentIndexS-1, currentIndexP-1, s, p, cache);
        }
        else if(p.charAt(currentIndexP-1) == '*')
        {
            return cache[currentIndexS][currentIndexP] = checkForPatternMatch(currentIndexS-1, currentIndexP-1, s, p, cache) || checkForPatternMatch(currentIndexS-1, currentIndexP, s, p, cache) || checkForPatternMatch(currentIndexS, currentIndexP-1, s, p, cache);
        }
        return cache[currentIndexS][currentIndexP] = false;
    }
}