class Solution {
    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length][coins[0].length][3];
        for(int[][] rr : dp)
        {
            for(int[] r : rr)
            {
                Arrays.fill(r, -1);
            }
        }
        return getAns(0, 0, 2, coins, dp);
    }
    private int getAns(int row, int col, int k, int[][] grid, int[][][] dp)
    {
        if(row == grid.length-1 && col == grid[0].length-1)
        {
            if(grid[row][col] < 0)
            {
                if(k > 0)
                {
                    return 0;
                }
            }
            return grid[row][col];
        }
        if(dp[row][col][k] != -1)
        {
            return dp[row][col][k];
        }
        int[][] moves = {{0,1}, {1,0}};
        int ans = Integer.MIN_VALUE;
        for(int[] move : moves)
        {
            int nr = row + move[0];
            int nc = col + move[1];
            if(nr == grid.length || nc == grid[0].length)
            {
                continue;
            }
            int doNotNeutralize = grid[row][col] + getAns(nr, nc, k, grid, dp);
            if(grid[row][col] < 0 && k > 0)
            {
                int neutralize = getAns(nr, nc, k-1, grid, dp);
                ans = Math.max(ans,  Math.max(neutralize, doNotNeutralize));
            }
            else
            {
                ans = Math.max(ans, doNotNeutralize);
            }
        }
        return dp[row][col][k] = ans;
    }
}