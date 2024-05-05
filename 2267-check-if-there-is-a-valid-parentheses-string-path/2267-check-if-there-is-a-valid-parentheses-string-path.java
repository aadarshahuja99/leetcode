class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Boolean[][][] cache = new Boolean[m][n][201];
        return checkForValidPath(0, 0, 0, grid, m, n, cache);
    }
    private boolean checkForValidPath(int row, int col, int total, char[][] grid, int m, int n, Boolean[][][] cache)
    {
        int currentTotal = total + (grid[row][col] == ')' ? -1 : 1);
        if(row == m-1 && col == n-1)
        {
            return currentTotal == 0;
        }
        if(currentTotal < 0)
        {
            return false;
        }
        if(cache[row][col][total] != null)
        {
            return cache[row][col][total];
        }
        int[][] nextOptions = new int[][] {{1,0}, {0,1}};
        boolean ans = false;
        for(int[] option : nextOptions)
        {
            int newRow = row + option[0];
            int newCol = col + option[1];
            if(isValid(newRow, newCol, m, n))
            {
                ans = ans || checkForValidPath(newRow, newCol, currentTotal, grid, m, n, cache);
                if(ans)
                {
                    return cache[row][col][total] = true;
                }
            }
        }
        return cache[row][col][total] = false;
    }
    private boolean isValid(int row, int col, int m, int n)
    {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}