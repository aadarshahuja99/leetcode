class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    q.add(new int[] { i, j, 0 });
                    vis[i][j] = true;
                }
            }
        }
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
                if(!vis[nr][nc] && grid[nr][nc] == 1)
                {
                    vis[nr][nc] = true;
                    ans[nr][nc] = d+1;
                    q.add(new int[] { nr, nc, d+1 });
                }
            }
        }
        return ans;
    }
}