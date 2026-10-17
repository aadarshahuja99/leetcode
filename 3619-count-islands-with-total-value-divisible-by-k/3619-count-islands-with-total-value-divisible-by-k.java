class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!vis[i][j] && grid[i][j] > 0)
                {
                    // perform dfs and get sum of the island
                    long sum = dfs(i, j, grid, vis);
                    if(sum%k == 0)
                    {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private long dfs(int r, int c, int[][] grid, boolean[][] vis)
    {
        vis[r][c] = true;
        int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        long currentSum = grid[r][c];
        for(int[] d : delta)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr == grid.length || nr < 0 || nc == grid[0].length || nc < 0 || vis[nr][nc] || grid[nr][nc] <= 0)
            {
                continue;
            }
            currentSum += dfs(nr, nc, grid, vis);
        }
        return currentSum;
    }
}