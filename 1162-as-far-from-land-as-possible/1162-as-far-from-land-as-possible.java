class Solution {
    public int maxDistance(int[][] grid) {
        // start bfs from land cells
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int landCount = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    landCount++;
                    q.add(new int[] { i, j, 0 });
                    vis[i][j] = true;
                }
            }
        }
        if(landCount == 0 || landCount == m*n)
        {
            return -1;
        }
        int ans = 0;
        int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(q.size() > 0)
        {
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];
            int d = top[2];
            for(int[] dir : DIRS)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nr == m || nc < 0 || nc == n)
                {
                    continue;
                }
                if(!vis[nr][nc] && grid[nr][nc] == 0)
                {
                    vis[nr][nc] = true;
                    ans = Math.max(d+1, ans);
                    q.add(new int[] { nr, nc, d+1 });
                }
            }
        }
        return ans;
    }
}