class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int freshCount = 0;
        int rottenCount = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                {
                    rottenCount++;
                    vis[i][j] = true;
                    q.add(new int[] { i,j });
                }
                if(grid[i][j] == 1)
                {
                    freshCount++;
                }
            }
        }
        if(freshCount == 0)
        {
            return 0;
        }
        if(rottenCount == 0)
        {
            return -1;
        }
        int levelsOfOranges = 0;
        while(q.size() > 0)
        {
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                int[] top = q.poll();
                int r = top[0];
                int c = top[1];
                for(int[] d : delta)
                {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if(nr < 0 || nr == m || nc < 0 || nc == n)
                    {
                        continue;
                    }
                    if(!vis[nr][nc] && grid[nr][nc] == 1)
                    {
                        vis[nr][nc] = true;
                        freshCount--;
                        if(freshCount == 0)
                        {
                            return levelsOfOranges+1;
                        }
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            levelsOfOranges++;
        }
        return -1;
    }
}