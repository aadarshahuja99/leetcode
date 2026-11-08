class Solution {
    int[][] DELTA = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1 && !vis[i][j])
                {
                    ans = Math.max(ans, bfs(i, j, vis, grid));
                }
            }
        }
        return ans;
    }
    private int bfs(int r, int c, boolean[][] vis,  int[][] grid)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        int ans = 0;
        vis[r][c] = true;
        
        while(q.size() > 0)
        {
            int[] top = q.poll();
            ans++;
            for(int[] d : DELTA)
            {
                int nr = top[0] + d[0];
                int nc = top[1] + d[1];
                if(nr < 0 || nr == grid.length || nc < 0 || nc == grid[0].length || grid[nr][nc] == 0 || vis[nr][nc])
                {
                    continue;
                }
                q.add(new int[] {nr, nc});
                vis[nr][nc] = true;
            }
        }
        return ans;
    }
}