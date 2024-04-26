class Solution {
    public int minFallingPathSum(int[][] grid) {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;
        int[][] cache = new int[numberOfRows][numberOfColumns+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, grid, numberOfRows, numberOfColumns, cache);
    }
    private int getAns(int currentRow, int lastColumn, int[][] grid, int numberOfRows, int numberOfColumns, int[][] cache)
    {
        if(currentRow == numberOfRows)
        {
            return 0;
        }
        if(cache[currentRow][lastColumn] != -1)
        {
            return cache[currentRow][lastColumn];
        }
        int ans = 2*10000;
        for(int i=1; i<=numberOfColumns; i++)
        {
            if(lastColumn == i)
            {
                continue;
            }
            ans = Math.min(ans, grid[currentRow][i-1] + getAns(currentRow+1, i, grid, numberOfRows, numberOfColumns, cache));
        }
        return cache[currentRow][lastColumn] = ans;
    }
}