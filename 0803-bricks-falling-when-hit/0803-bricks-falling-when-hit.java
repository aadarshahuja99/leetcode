class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int[] hit : hits)
        {
            if(grid[hit[0]][hit[1]] == 0)
            {
                grid[hit[0]][hit[1]] = -1;
            }
            else
            {
                grid[hit[0]][hit[1]] = 0;
            }
        }
        // offline queries based question where brute force can not work, we can think of doing the reverse of what is asked in the question.
        // In this case, we initially do not connect the bricks in hits array. Then we add them one by one and check the number of new bricks that got connected because of them.
        for(int i=0; i<n; i++)
        {
            if(grid[0][i] == 1 && visited[0][i] == 0)
            {
                dfs(0, i, visited, grid);
            }
        }
        int[] ans = new int[hits.length];
        for(int idx = hits.length-1; idx >= 0; idx--)
        {
            int row = hits[idx][0];
            int column = hits[idx][1];
            if(grid[row][column] == 0)
            {
                grid[row][column] = 1;
                if(checkIfTheCellIsConnectedToTop(row, column, visited))
                {
                    ans[idx] = dfs(row, column, visited, grid) - 1;
                }
            }
        }
        return ans;
    }
    private boolean checkIfTheCellIsConnectedToTop(int row, int column, int[][] visited)
    {
        return ((row - 1 >= 0 && visited[row-1][column] == 1) || (row + 1 < visited.length && visited[row+1][column] == 1)
        || (column - 1 >= 0 && visited[row][column-1] == 1) || (column + 1 < visited[0].length && visited[row][column+1] == 1)) || row == 0;
    }
    private int dfs(int currentRow, int currentColumn, int[][] visited, int[][] grid)
    {
        visited[currentRow][currentColumn] = 1;
        int[] deltaRow = new int[] { 0, 1, 0, -1 };
        int[] deltaColumn = new int[] { -1, 0, 1, 0 };
        int m = grid.length;
        int n = grid[0].length;
        int count = 1;
        for(int i=0; i<4; i++)
        {
            int newRow = currentRow + deltaRow[i];
            int newColumn = currentColumn + deltaColumn[i];
            if(newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n && grid[newRow][newColumn] == 1 && visited[newRow][newColumn] == 0)
            {
                count += dfs(newRow, newColumn, visited, grid);
            }
        }
        return count;
    }
}