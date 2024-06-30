class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int ans = 0;
        TreeSet<Integer> values = new TreeSet<>();
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                values.add(grid[i][j]);
            }
        }
        List<Integer> vals = new ArrayList<>();
        for(int v : values)
        {
            vals.add(v);
        }
        int start = 0;
        int end = vals.size() - 1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            int current = vals.get(mid);
            if(check(current, grid))
            {
                ans = current;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return ans;
    }
    private boolean check(int mid, int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        if(grid[0][0] < mid)
        {
            return false;
        }
        dfs(0,0,grid,vis,mid);
        if(vis[m-1][n-1])
        {
            // System.out.println("1: "+mid);
            return true;
        }
        // System.out.println("2: "+mid);
        return false;
    }
    private void dfs(int r, int c, int[][] grid, boolean[][] vis, int mid)
    {
        vis[r][c] = true;
        int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int[] d : delta)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] < mid || vis[nr][nc])
            {
                continue;
            }
            dfs(nr, nc, grid, vis, mid);
        }
    }
}