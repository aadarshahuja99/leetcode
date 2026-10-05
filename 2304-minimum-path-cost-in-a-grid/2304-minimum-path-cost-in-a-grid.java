class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                int value = grid[i][j];
                if(i == m-1)
                {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                for(int k=0; k<n; k++)
                {
                    int cost = moveCost[value][k];
                    dp[i][j] = Math.min(dp[i][j], grid[i][j] + cost + dp[i+1][k]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }
}