class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int numRows = obstacleGrid.length;
        int numColumns = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[numRows-1][numColumns-1] == 1)
        {
            return 0;
        }

        int[][] dp = new int[numRows][numColumns];

        dp[numRows-1][numColumns-1] = 1;

        for(int i=numRows-1; i>=0; i--)
        {
            for(int j=numColumns-1; j>=0; j--)
            {
                if(i == numRows - 1 && j == numColumns - 1)
                {
                    continue;
                }
                int[] rowChange = { 0,1 };
                int[] columnChange = { 1,0 };
                int paths = 0;
                for(int k=0; k<2; k++)
                {
                    int nextRow = i + rowChange[k];
                    int nextColumn = j + columnChange[k];
                    if(validatePosition(nextRow, nextColumn, numRows, numColumns) && obstacleGrid[nextRow][nextColumn] != 1)
                    {
                        paths += dp[nextRow][nextColumn];
                    }
                }
                dp[i][j] = paths;
            }
        }

        return dp[0][0];

        // for(int[] row : dp)
        // {
        //     Arrays.fill(row,-1);
        // }
        // return getUniquePaths(0, 0, obstacleGrid, numRows, numColumns, dp);
    }
    private int getUniquePaths(int currentRow, int currentColumn, int[][] grid, int numRows, int numColumns, int[][] dp)
    {
        if(currentRow == numRows-1 && currentColumn == numColumns-1)
        {
            return 1;
        }
        if(dp[currentRow][currentColumn] != -1)
        {
            return dp[currentRow][currentColumn];
        }
        int[] rowChange = { 0,1 };
        int[] columnChange = { 1,0 };
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