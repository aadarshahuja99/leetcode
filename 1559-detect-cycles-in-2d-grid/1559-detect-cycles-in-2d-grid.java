class Solution {
    public boolean containsCycle(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis = new boolean[r][c];
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(!vis[i][j] && dfs(i, j, -1, -1, vis, grid))
                {
                    return true;
                }
                // System.out.println("not found from "+i+" , "+j);
            }
        }
        return false;
    }
    private boolean dfs(int r, int c, int pr, int pc, boolean[][] vis, char[][] grid)
    {
        vis[r][c] = true;
        int[][] DIRs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int[] d : DIRs)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr == grid.length || nc < 0 || nc == grid[0].length || grid[nr][nc] != grid[r][c] || (pr == nr && pc == nc))
            {
                continue;
            }
            if(vis[nr][nc])
            {
                // System.out.println("found for "+nr+", "+nc+" and "+r+", "+c);
                return true;
            }
            if(dfs(nr, nc, r, c, vis, grid))
            {
                return true;
            }
        }
        return false;
    }
}