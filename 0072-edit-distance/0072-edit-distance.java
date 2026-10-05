class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] cache = new int[m+1][n+1];
        // base case
        for(int i=0; i<=m; i++)
        {
            cache[i][0] = i;
        }
        for(int j=0; j<=n; j++)
        {
            cache[0][j] = j;
        }
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    // move both and do not add anything to cost
                    cache[i][j] = cache[i-1][j-1];
                }
                else
                {
                    // i,j-1 means insert in word1, i-1, j means delete from word1 and i-1, j-1 means edit
                    cache[i][j] = 1 + Math.min(cache[i][j-1], Math.min(cache[i-1][j], cache[i-1][j-1]));
                }
            }
        }
        return cache[m][n];
        //return getAns(word1.length(), word2.length(), word1, word2, cache);
    }
    private int getAns(int i, int j, String w1, String w2, int[][] cache)
    {
        if(i == 0 && j == 0)
        {
            return 0;
        }
        if(i == 0)
        {
            return j;
        }
        if(j == 0)
        {
            return i;
        }
        if(cache[i][j] != -1)
        {
            return cache[i][j];
        }
        if(w1.charAt(i-1) == w2.charAt(j-1))
        {
            return cache[i][j] = getAns(i-1, j-1, w1, w2, cache);
        }
        // i-1,j means deleting the character from 1st string, i-1,j-1 means edit, and i,j-1 means inserting a character in 1st string equal to w2.charAt(j-1)
        return cache[i][j] = 1 + Math.min(getAns(i-1, j, w1, w2, cache), Math.min(getAns(i-1, j-1, w1, w2, cache), getAns(i, j-1, w1, w2, cache)));
    }
}