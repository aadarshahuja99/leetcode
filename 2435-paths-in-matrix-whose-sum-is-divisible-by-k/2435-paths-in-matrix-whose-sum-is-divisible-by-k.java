class Solution {
    int modulo = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k];
        for(int[][] row : dp)
        {
            for(int[] nestedRow : row)
            {
                Arrays.fill(nestedRow,-1);
            }
        }
        return getAns(0,0,grid[0][0]%k,k,grid,grid.length,grid[0].length,dp);
    }
    private int getAns(int r, int c, int mod, int k, int[][] grid, int m, int n, int[][][] dp)
    {
        if(r == m-1 && c == n-1)
        {
            // int rem = (mod + grid[r][c]%k)%k;
            return mod == 0 ? 1 : 0;
        }
        if(dp[r][c][mod] != -1)
        {
            return dp[r][c][mod];
        }
        int[] deltaRow = new int[] { 1,0 };
        int[] deltaCol = new int[] { 0,1 };
        int ans = 0;
        for(int i=0; i<2; i++)
        {
            int newRow = deltaRow[i] + r;
            int newCol = deltaCol[i] + c;
            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
            {
                continue;
            }
            ans = (ans%modulo + getAns(newRow, newCol, (mod + grid[newRow][newCol]%k)%k, k, grid, m, n, dp)%modulo)%modulo;
        }
        return dp[r][c][mod] = ans;
    }
}