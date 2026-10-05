class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] cache = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
        {
            cache[i][0] = 1;
        }
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                // in case the characters match, we have a choice to either take the current s character or not take it in the subsequence. First cache read is the notTake one
                if(s.charAt(i-1) == t.charAt(j-1))
                {
                    cache[i][j] = cache[i-1][j] + cache[i-1][j-1];
                }
                else
                {
                    cache[i][j] = cache[i-1][j];
                }
            }
        }
        return cache[m][n];
        // return getAns(0, 0, s, t, s.length(), t.length(), cache);
    }
    private int getAns(int i, int j, String s, String t, int m, int n, int[][] cache)
    {
        if(j == n)
        {
            return 1;
        }
        if(i == m)
        {
            return 0;
        }
        if(cache[i][j] != -1)
        {
            return cache[i][j];
        }
        if(s.charAt(i) == t.charAt(j))
        {
            return cache[i][j] = getAns(i+1, j+1, s, t, m, n, cache) + getAns(i+1, j, s, t, m, n, cache);
        }
        return cache[i][j] = getAns(i+1, j, s, t, m, n, cache);
    }
}