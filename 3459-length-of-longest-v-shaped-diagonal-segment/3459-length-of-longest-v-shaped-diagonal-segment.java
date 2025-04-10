class Solution {
    int[][] DIRS = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};
    public int lenOfVDiagonal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int[][][][] dp = new int[m][n][4][2];
        for(int[][][] nnr : dp)
        {
            for(int[][] nr : nnr)
            {
                for(int[] r : nr)
                {
                    Arrays.fill(r,-1);
                }
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    int id = 0;
                    for(int[] d : DIRS)
                    {
                        int nr = i+d[0];
                        int nc = j+d[1];
                        if(nr >= 0 && nr < m && nc < n && nc >= 0 && grid[nr][nc] == 2)
                        {
                            ans = Math.max(ans, 1 + getAns(nr, nc, id, 0, m, n, grid, dp));
                        }
                        else
                        {
                            ans = Math.max(1, ans);
                        }
                        id++;
                    }
                }
            }
        }
        return ans;
    }
    private int getAns(int r, int c, int dir, int hasChanged, int m, int n, int[][] grid, int[][][][] dp)
    {
        if(dp[r][c][dir][hasChanged] != -1)
        {
            return dp[r][c][dir][hasChanged];
        }
        int dontChange = 1;
        int nr = r+DIRS[dir][0];
        int nc = c+DIRS[dir][1];
        if(nr >= 0 && nr < m && nc < n && nc >= 0 && ((grid[r][c] == 2 && grid[nr][nc] == 0) || (grid[r][c] == 0 && grid[nr][nc] == 2)))
        {
            dontChange = 1 + getAns(nr, nc, dir, hasChanged, m, n, grid, dp);
        }
        if(hasChanged == 0)
        {
            int change = 1;
            int i = getOtherDirs(dir);
            int newr = r+DIRS[i][0];
            int newc = c+DIRS[i][1];
            if(newr >= 0 && newr < m && newc < n && newc >= 0 && ((grid[r][c] == 2 && grid[newr][newc] == 0) || (grid[r][c] == 0 && grid[newr][newc] == 2)))
            {
                change = Math.max(change, 1 + getAns(newr, newc, i, 1, m, n, grid, dp));
            }
            // System.out.println(Math.max(change, dontChange)+" ans starting from "+(r)+","+c+","+dir+","+hasChanged);
            return dp[r][c][dir][hasChanged] = Math.max(change, dontChange);
        }
        // System.out.println(dontChange+" ans starting from "+(r)+","+c+","+dir+","+hasChanged);
        return dp[r][c][dir][hasChanged] = dontChange;
    }
    private int getOtherDirs(int dir)
    {
        var ans = new ArrayList<Integer>();
        if(dir == 0)
        {
            return 1;
        }
        if(dir == 1)
        {
            return 3;
        }
        if(dir == 2)
        {
            return 0;
        }
        return 2;
    }
}