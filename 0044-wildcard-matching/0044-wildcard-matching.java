class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] cache = new Boolean[s.length()+1][p.length()+1];
        return checkForPatternMatch(s.length(), p.length(), s, p, cache);
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