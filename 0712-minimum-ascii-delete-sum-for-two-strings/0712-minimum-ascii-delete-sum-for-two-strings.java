class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] cache = new int[m+1][n+1];
        int[] pre1 = new int[m];
        int[] pre2 = new int[n];
        int idx=0;
        for(char c : s1.toCharArray())
        {
            pre1[idx] = idx > 0 ? pre1[idx-1] + (int)(c) : (int)(c);
            idx++;
        }
        idx = 0;
        for(char c : s2.toCharArray())
        {
            pre2[idx] = idx > 0 ? pre2[idx-1] + (int)(c) : (int)(c);
            idx++;
        }
        for(int i=1; i<=m; i++)
        {
            cache[i][0] = pre1[i-1];
        }
        for(int i=1; i<=n; i++)
        {
            cache[0][i] = pre2[i-1];
        }
        for(int i=1; i<= m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                {
                    cache[i][j] = cache[i-1][j-1];
                }
                else
                {
                    cache[i][j] = Math.min((int)(s1.charAt(i-1)) + cache[i-1][j], (int)(s2.charAt(j-1)) + cache[i][j-1]);
                }
            }
        }
        return cache[m][n];
    }
}