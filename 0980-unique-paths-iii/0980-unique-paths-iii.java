class Solution {
    int ans = 0;
    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int freeCells = 0;
        int sourceRow = 0;
        int sourceCol = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    freeCells++;
                }
                if(grid[i][j] == 1)
                {
                    sourceRow = i;
                    sourceCol = j;
                }
            }
        }
        vis[sourceRow][sourceCol] = true;
        // System.out.println(freeCells+" "+sourceRow + " "+sourceCol);
        findPaths(sourceRow, sourceCol, grid, vis, freeCells);
        return ans;
    }
    private void findPaths(int row, int col, int[][] grid, boolean[][] visited, int remaining)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[row][col] == 2)
        {
            if(remaining == 0)
            {
                ans += 1;
            }
            return;
        }
        // if(remaining == 0)
        // {
        //     re
        // }
        int count = 0;
        int[][] delta = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int i=0; i<4; i++)
        {
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && grid[newRow][newCol] != -1)
            {
                visited[newRow][newCol] = true;
                findPaths(newRow, newCol, grid, visited, grid[newRow][newCol] == 0 ? remaining - 1 : remaining);
                visited[newRow][newCol] = false;
            }
        }
        return;
    }
}