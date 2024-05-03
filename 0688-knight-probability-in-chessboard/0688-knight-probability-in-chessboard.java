class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] cache = new double[n][n][k+1];
        for(double[][] outerRow : cache)
        {
            for(double[] nestedRow : outerRow)
            {
                Arrays.fill(nestedRow, -1);
            }
        }
        return getAns(row, column, k, n, cache);
    }

    private double getAns(int row, int col, int k, int n, double[][][] cache)
    {
        if(k==0)
        {
            return 1.0;
        }
        if(cache[row][col][k] != -1)
        {
            return cache[row][col][k];
        }

        int[] deltaRow = new int[] { 1,-1,2,-2,1,-1,2,-2 };
        int[] deltaCol = new int[] { -2,2,-1,1,2,-2,1,-1 };
        double ans = 0;

        for(int i=0; i<8; i++)
        {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if(isValidPosition(newRow, newCol, n))
            {
                ans += 0.125*getAns(newRow, newCol, k-1, n, cache);
            }
        }

        return cache[row][col][k] = ans;
    }

    private boolean isValidPosition(int row, int col, int n)
    {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}