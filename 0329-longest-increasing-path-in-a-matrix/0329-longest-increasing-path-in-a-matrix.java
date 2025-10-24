class Solution {
    int ans = 1;
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                if(dp[i][j] == -1)
                {
                    dfs(i,j,matrix,dp);
                }
            }
        }
        return ans;
    }
    private int dfs(int row, int col, int[][] grid, int[][] dp)
    {
        int[] deltaRow = new int[] { 0,1,0,-1 };
        int[] deltaCol = new int[] { 1,0,-1,0 };
        int max = 1;
        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }
        for(int i=0; i<4; i++)
        {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] > grid[row][col])
            {
                max = Math.max(max, 1 + dfs(newRow,newCol,grid,dp));
            }
        }
        dp[row][col] = max;
        ans = Math.max(max, ans);
        return max;
    }
}