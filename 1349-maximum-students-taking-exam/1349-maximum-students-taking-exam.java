class Solution {
    public int maxStudents(char[][] seats) {
        int r = seats.length;
        int c = seats[0].length;
        int max = (1<<c);
        int[][][][] dp = new int[r][c][max][max];
        for(int[][][] nnr : dp)
        {
            for(int[][] nr : nnr)
            {
                for(int[] row : nr)
                {
                    Arrays.fill(row, -1);
                }
            }
        }
        return getAns(0, 0, 0, 0, seats, dp);
    }
    private int getAns(int row, int col, int lastMask, int currentMask, char[][] seats, int[][][][] dp)
    {
        int cols = seats[0].length;
        if(row == seats.length)
        {
            return 0;
        }
        if(col == cols)
        {
            return getAns(row+1, 0, currentMask, 0, seats, dp);
        }
        if(dp[row][col][lastMask][currentMask] != -1)
        {
            return dp[row][col][lastMask][currentMask];
        }
        if(seats[row][col] == '#')
        {
            return dp[row][col][lastMask][currentMask] = getAns(row, col+1, lastMask, currentMask, seats, dp);
        }
        if((col-1 >= 0 && (currentMask&(1<<(col-1))) == 0 && (lastMask&(1<<(col-1))) == 0
        && (lastMask&(1<<(col+1))) == 0) || (col == 0 && (lastMask&(1<<(col+1))) == 0))
        {
            return dp[row][col][lastMask][currentMask] = Math.max(
                1 + getAns(row, col+1, lastMask, (currentMask|(1<<(col))), seats, dp),
                getAns(row, col+1, lastMask, currentMask, seats, dp)
            );
        }
        return dp[row][col][lastMask][currentMask] = getAns(row, col+1, lastMask, currentMask, seats, dp);
    }
}