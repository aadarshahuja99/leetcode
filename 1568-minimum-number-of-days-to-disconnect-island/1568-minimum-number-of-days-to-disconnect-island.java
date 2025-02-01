class Solution {
    int[][] DIRS = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    int[][] tin;
    int[][] low;
    int ans = -1;
    int timer;
    HashSet<Integer> set = new HashSet<>();
    public int minDays(int[][] grid) {
        // ans can never be more than 2
        // ans = 0 if more than 1 islands already exist
        // ans = 1 (check if an articulation point exists using tarjan's modified articulation point algorithm)
        // else ans = 2
        int islands = countIslands(grid);
        if(islands != 1)
        {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        timer = 0;
        tin = new int[m][n];
        low = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1 && !vis[i][j])
                {
                    tarjan(i, j, -1, -1, vis, grid, m, n);
                    break;
                }
            }
        }
        if(set.size() == 0)
        {
            return 2;
        }
        return 1;
    }
    private void tarjan(int r, int c, int pr, int pc, boolean[][] vis, int[][] grid, int m , int n)
    {
        vis[r][c] = true;
        tin[r][c] = low[r][c] = timer;
        timer++;
        int children = 0;
        for(int[] d : DIRS)
        {
            int nr = d[0] + r;
            int nc = d[1] + c;
            if(nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] == 0)
            {
                continue;
            }
            if(!vis[nr][nc])
            {
                tarjan(nr, nc, r, c, vis, grid, m, n);
                children++;
                low[r][c] = Math.min(low[nr][nc], low[r][c]);
                if(low[nr][nc] >= tin[r][c] && pr != -1 && pc != -1)
                {
                    set.add(r*n + c);
                }
            }
            else if(nr != pr || nc != pc)
            {
                low[r][c] = Math.min(tin[nr][nc], low[r][c]);
            }
        }
        if(pr == -1 && pc == -1 && (children > 1 || children == 0))
        {
            set.add(r*n + c);
        }
    }
    private int countIslands(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!vis[i][j] && grid[i][j] == 1)
                {
                    count++;
                    if(count == 2)
                    {
                        return 2;
                    }
                    dfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
    private void dfs(int r, int c, boolean[][] vis, int[][] grid)
    {
        int m = vis.length;
        int n = vis[0].length;
        vis[r][c] = true;
        for(int[] d : DIRS)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr == m || nc < 0 || nc == n || grid[nr][nc] == 0 || vis[nr][nc])
            {
                continue;
            }
            dfs(nr, nc, vis, grid);
        }
    }
}