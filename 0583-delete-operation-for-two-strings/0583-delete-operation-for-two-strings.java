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
                    // i,j-1 means delete from word2, i-1, j means delete from word1
                    cache[i][j] = 1 + Math.min(cache[i][j-1], cache[i-1][j]);
                }
            }
        }
        return cache[m][n];
    }
}