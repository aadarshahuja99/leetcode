class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] ones = new int[strs.length];
        int[] zeroes = new int[strs.length];
        int idx = 0;
        for(String s : strs)
        {
            int countOnes = 0;
            int countZeroes = 0;
            for(int i=0; i<s.length(); i++)
            {
                if(s.charAt(i) == '0')
                {
                    countZeroes++;
                }
                else
                {
                    countOnes++;
                }
            }
            ones[idx] = countOnes;
            zeroes[idx] = countZeroes;
            idx++;
        }
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int current = strs.length-1; current >= 0; current--)
        {
            for(int i = 0; i <= m; i++)
            {
                for(int j=0; j <= n; j++)
                {
                    if(ones[current] <= j && zeroes[current] <= i)
                    {
                        dp[current][i][j] = Math.max(dp[current+1][i][j], 1 + dp[current+1][i-zeroes[current]][j-ones[current]]);
                    }
                    else
                    {
                        dp[current][i][j] = dp[current+1][i][j];
                    }
                }
            }
        }
        return dp[0][m][n];
    }
}