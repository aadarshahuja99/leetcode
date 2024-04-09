class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if((i == 0 || i == m-1 || j == 0 || j == n-1) && visited[i][j] == 0 && grid[i][j] == 0)
                {
                    dfs(i,j,visited,grid);
                }
            }
        }
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0 && visited[i][j] == 0)
                {
                    dfs(i,j,visited,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    private void dfs(int row, int col, int[][] visited, int[][] grid)
    {
        visited[row][col] = 1;
        int[] deltaRow = new int[] { 0,1,0,-1 };
        int[] deltaCol = new int[] { 1,0,-1,0 };
        for(int i=0; i<4; i++)
        {
            int newRow = deltaRow[i] + row;
            int newCol = deltaCol[i] + col;
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 0)
            {
                dfs(newRow, newCol, visited, grid);
            }
        }
    }
}