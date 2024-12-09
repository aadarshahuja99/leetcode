class Solution {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()][t.length()];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, s, t, s.length(), t.length(), cache);
    }
    private int getAns(int i, int j, String s, String t, int m, int n, int[][] cache)
    {
        if(i == m)
        {
            return j == n ? 1 : 0;
        }
        if(j == n)
        {
            return 1;
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