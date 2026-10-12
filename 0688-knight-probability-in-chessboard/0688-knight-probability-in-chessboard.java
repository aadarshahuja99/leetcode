class Solution {
    int[][] dirs = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] cache = new double[n][n][k+1];
        for(double[][] r : cache)
        {
            for(double[] nested : r)
            {
                Arrays.fill(nested, -1.0);
            }
        }
        return getAns(row, column, k, n, cache);
    }
    private double getAns(int r, int c, int moves, int n, double[][][] cache)
    {
        if(moves == 0)
        {
            return 1.0;
        }
        if(cache[r][c][moves] != -1)
        {
            return cache[r][c][moves];
        }
        double current = 0.0;
        for(int[] d : dirs)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < n)
            {
                current += 0.125*getAns(nr, nc, moves-1, n, cache);
            }
        }
        return cache[r][c][moves] = current;
    }
}