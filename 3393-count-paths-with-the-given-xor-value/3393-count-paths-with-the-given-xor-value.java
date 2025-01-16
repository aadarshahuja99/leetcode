class Solution {
    int MOD = 1_000_000_007;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][16];
        for(int[][] nested : dp)
        {
            for(int[] row : nested)
            {
                Arrays.fill(row, -1);
            }
        }
        return getAns(0, 0, grid[0][0], k, grid, dp);
    }
    private int getAns(int row, int col, int currentXor, int k, int[][] grid, int[][][] dp)
    {
        int rows = grid.length;
        int cols = grid[0].length;
        if(row == rows-1 && col == cols-1)
        {
            return currentXor == k ? 1 : 0;
        }
        if(dp[row][col][currentXor] != -1)
        {
            return dp[row][col][currentXor];
        }
        int[][] dirs = {{1,0}, {0,1}};
        int ans = 0;
        for(int[] d : dirs)
        {
            int nr = d[0] + row;
            int nc = d[1] + col;
            if(nr < 0 || nr == rows || nc < 0 || nc == cols)
            {
                continue;
            }
            ans = (ans%MOD + getAns(nr, nc, currentXor^grid[nr][nc], k, grid, dp)%MOD)%MOD;
        }
        return dp[row][col][currentXor] = ans;
    }
}