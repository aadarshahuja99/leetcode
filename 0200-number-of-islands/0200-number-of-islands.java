class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int count = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(visited[i][j] == 0 && grid[i][j] == '1')
                {
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int row, int col, int[][] visited, char[][] grid)
    {
        visited[row][col] = 1;
        int[] deltaRow = new int[] { 0,1,0,-1 };
        int[] deltaColumn = new int[] { 1,0,-1,0 };
        int m = visited.length;
        int n = visited[0].length;
        for(int i=0; i<4; i++)
        {
            int newRow = row + deltaRow[i];
            int newColumn = col + deltaColumn[i];
            if(newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && visited[newRow][newColumn] == 0 && grid[newRow][newColumn] == '1')
            {
                dfs(newRow, newColumn, visited, grid);
            }
        }
    }
}