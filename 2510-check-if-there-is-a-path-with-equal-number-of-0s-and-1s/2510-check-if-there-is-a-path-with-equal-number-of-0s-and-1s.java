class Solution {
    public boolean isThereAPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numberOfSelections = m + n - 1;
        int maxValue = 2*numberOfSelections + 1;
        Boolean[][][] cache = new Boolean[m][n][maxValue];
        return checkIfPathExists(0, 0, numberOfSelections, numberOfSelections, grid, cache);
    }
    private boolean checkIfPathExists(int currentRow, int currentColumn, int balance, int factor, int[][] grid, Boolean[][][] cache)
    {
        int m = grid.length;
        int n = grid[0].length;
        int valueToBeAddedToBalance = grid[currentRow][currentColumn] == 0 ? -1 : 1;
        if(currentRow == m-1 && currentColumn == n-1)
        {
            // System.out.println((balance + valueToBeAddedToBalance)+" "+(factor));
            return balance + valueToBeAddedToBalance == factor;
        }
        if(cache[currentRow][currentColumn][balance] != null)
        {
            return cache[currentRow][currentColumn][balance];
        }
        int[][] delta = {{0,1}, {1,0}};
        boolean ans = false;
        for(int i=0; i<2; i++)
        {
            int newRow = currentRow + delta[i][0];
            int newCol = currentColumn + delta[i][1];
            if(validateCell(newRow, newCol, m, n))
            {
                ans = ans || checkIfPathExists(newRow, newCol, balance + valueToBeAddedToBalance, factor, grid, cache);
            }
        }
        return cache[currentRow][currentColumn][balance] = ans;
    }
    private boolean validateCell(int row, int col, int rows, int columns)
    {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}