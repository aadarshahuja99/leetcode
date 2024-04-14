class Solution {
    public int numEnclaves(int[][] grid) {
        int numRows = grid.length;
        int numColumns = grid[0].length;
        int[][] visited = new int[numRows][numColumns];
        int totalOnes = 0;
        int onesReachableFromBoundary = 0;
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<numColumns; j++)
            {
                if(grid[i][j] == 1)
                {
                    totalOnes++;
                    if(((i == 0 || i == numRows-1) || (j == numColumns - 1 || j == 0)) && visited[i][j] == 0)
                    {
                        onesReachableFromBoundary += dfs(i, j, visited, grid, numRows, numColumns);
                    }
                }
            }
        }
        return totalOnes - onesReachableFromBoundary;
    }
    private int dfs(int row, int col, int[][] visited, int[][] grid, int numRows, int numColumns)
    {
        visited[row][col] = 1;
        int size = 1;
        int[][] adjacents = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int[] adjacent : adjacents)
        {
            int newRow = adjacent[0] + row;
            int newCol = adjacent[1] + col;
            if(validatePosition(newRow, newCol, numRows, numColumns, grid) && visited[newRow][newCol] == 0)
            {
                size += dfs(newRow, newCol, visited, grid, numRows, numColumns);
            }
        }
        return size;
    }
    private boolean validatePosition(int row, int col, int numRows, int numColumns, int[][] grid)
    {
        return row < numRows && row >= 0 && col < numColumns && col >= 0 && grid[row][col] == 1;
    }
}