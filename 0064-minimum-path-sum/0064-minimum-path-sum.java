class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(i == m-1 && j == n-1)
                {
                    continue;
                }
                int current = Integer.MAX_VALUE;
                int[][] delta = {{0,1}, {1,0}};
                for(int[] d : delta)
                {
                    int newRow = i+d[0];
                    int newCol = j+d[1];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                    {
                        current = Math.min(current, grid[i][j] + dp[newRow][newCol]);
                    }
                }
                dp[i][j] = current;
            }
        }
        return dp[0][0];
    }
}