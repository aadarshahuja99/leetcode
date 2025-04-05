class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int[][] row : dp)
        {
            for(int[] nestedRow : row)
            {
                Arrays.fill(nestedRow, -1);
            }
        }
        return grid[0][0] + grid[0][grid[0].length-1] + getAns(0,0,grid[0].length-1,grid,dp);
    }
    private int getAns(int row, int col1, int col2, int[][] grid, int[][][] dp)
    {
        if(row == grid.length-1)
        {
            return 0;
        }
        if(dp[row][col1][col2] != -1)
        {
            return dp[row][col1][col2];
        }
        int[] dC = new int[] { -1,0,1 };
        int ans = 0;
        for(int i=0; i<3; i++)
        {
            int c1 = col1 + dC[i];
            for(int j=0; j<3; j++)
            {
                int c2 = col2 + dC[j];
                if(c1 < grid[0].length && c1 >= 0 && c2 < grid[0].length && c2 >= 0)
                {
                    if(c1 == c2)
                    {
                        ans = Math.max(ans, grid[row+1][c1] + getAns(row+1, c1, c2, grid, dp));
                    }
                    else
                    {
                        ans = Math.max(ans, grid[row+1][c1] + grid[row+1][c2] + getAns(row+1, c1, c2, grid, dp));
                    }
                }
            }
        }
        return (dp[row][col1][col2] = ans);
    }
}