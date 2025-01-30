class Solution {
    HashSet<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(!vis[i][j] && grid[i][j] == 1)
                {
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, i, j, grid, vis, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int r, int c, int pr, int pc, int[][] grid, boolean[][] vis, StringBuilder current)
    {
        int valR = r - pr;
        int valC = c - pc;
        current.append(String.format("(%s,%s),", valR, valC));
        vis[r][c] = true;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] DIRS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] d : DIRS)
        {
            int nr = d[0] + r;
            int nc = d[1] + c;
            if(nr < 0 || nr == rows || nc < 0 || nc == cols || vis[nr][nc] || grid[nr][nc] == 0)
            {
                continue;
            }
            dfs(nr, nc, pr, pc, grid, vis, current);
        }
    }
}