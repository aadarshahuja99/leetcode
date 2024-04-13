class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
        {
            return 0;
        }
        int numRows = obstacleGrid.length;
        int numColumns = obstacleGrid[0].length;
        int[][] dp = new int[numRows][numColumns];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        return getUniquePaths(0, 0, obstacleGrid, numRows, numColumns, dp);
    }
    private int getUniquePaths(int currentRow, int currentColumn, int[][] grid, int numRows, int numColumns, int[][] dp)
    {
        if(currentRow == numRows-1 && currentColumn == numColumns-1)
        {
            if(grid[currentRow][currentColumn] == 1)
            {
                return 0;
            }
            return 1;
        }
        if(dp[currentRow][currentColumn] != -1)
        {
            return dp[currentRow][currentColumn];
        }
        int[] rowChange = new int[] { 0,1 };
        int[] columnChange = new int[] { 1,0 };
        int paths = 0;
        for(int i=0; i<2; i++)
        {
            int nextRow = currentRow + rowChange[i];
            int nextColumn = currentColumn + columnChange[i];
            if(validatePosition(nextRow, nextColumn, numRows, numColumns) && grid[nextRow][nextColumn] != 1)
            {
                paths += getUniquePaths(nextRow, nextColumn, grid, numRows, numColumns, dp);
            }
        }
        return dp[currentRow][currentColumn] = paths;
    }
    private boolean validatePosition(int row, int column, int numRows, int numColumns)
    {
        if(row >= 0 && row < numRows && column >= 0 && column < numColumns)
        {
            return true;
        }
        return false;
    }
}