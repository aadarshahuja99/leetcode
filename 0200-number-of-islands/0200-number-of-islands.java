class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1' && !vis[i][j])
                {
                    bfs(i,j,q,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(int sr, int sc, Queue<int[]> q, boolean[][] vis, char[][] grid)
    {
        int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        q.add(new int[] { sr, sc });
        while(q.size() > 0)
        {
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];
            for(int[] d : delta)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nr == vis.length || nc < 0 || nc == vis[0].length)
                {
                    continue;
                }
                if(vis[nr][nc] || grid[nr][nc] == '0')
                {
                    continue;
                }
                vis[nr][nc] = true;
                q.add(new int[] { nr, nc });
            }
        }
    }
}