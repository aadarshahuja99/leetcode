class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int maxComponentSize = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(visited[i][j] == 0 && grid[i][j] == 1)
                {
                    maxComponentSize = Math.max(maxComponentSize, calculateSize(i,j,visited,grid));
                }
            }
        }
        return maxComponentSize;
    }
    private int calculateSize(int row, int col, int[][] visited, int[][] grid)
    {
        visited[row][col] = 1;
        int[] deltaRow = new int[] { 0,1,0,-1 };
        int[] deltaColumn = new int[] { 1,0,-1,0 };
        int m = grid.length;
        int n = grid[0].length;
        int size = 1;
        for(int i=0; i<4; i++)
        {
            int newRow = deltaRow[i] + row;
            int newColumn = deltaColumn[i] + col;
            if(newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && visited[newRow][newColumn] == 0 && grid[newRow][newColumn] == 1)
            {
                size += calculateSize(newRow, newColumn, visited, grid);
            }
        }
        return size;
    }
}