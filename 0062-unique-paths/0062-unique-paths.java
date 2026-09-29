class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int[][] delta = {{0,1}, {1,0}};
                for(int[] d : delta)
                {
                    int nR = i + d[0];
                    int nC = j + d[1];
                    if(nR >= 0 && nR < m && nC >= 0 && nC < n)
                    {
                        dp[i][j] += dp[nR][nC];
                    }
                }
            }
        }
        return dp[0][0];
    }
}