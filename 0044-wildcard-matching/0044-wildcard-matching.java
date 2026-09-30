class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] cache = new boolean[m+1][n+1];
        boolean[]  lastRowOfCache = new boolean[n+1];
        lastRowOfCache[0] = true;
        for(int j=1; j<=n; j++)
        {
            lastRowOfCache[j] = lastRowOfCache[j-1] && p.charAt(j-1) == '*';
        }
        for(int i=1; i<=m; i++)
        {
            boolean[] currentRowOfCache = new boolean[n+1];
            for(int j=1; j<=n; j++)
            {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                {
                    currentRowOfCache[j] = lastRowOfCache[j-1];
                }
                else if(p.charAt(j-1) == '*')
                {
                    // 1st cache[i-1][j-1] means exactly one char match using the *, 2nd cache[i-1][j] means atleast one char match using the * and 3rd cache[i][j-1] means empty match using the * and * means nothing in that case.
                    currentRowOfCache[j] = lastRowOfCache[j-1] || lastRowOfCache[j] || currentRowOfCache[j-1];
                }
                else
                {
                    currentRowOfCache[j] = false;
                }
            }
            lastRowOfCache = currentRowOfCache;
        }
        return lastRowOfCache[n];
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