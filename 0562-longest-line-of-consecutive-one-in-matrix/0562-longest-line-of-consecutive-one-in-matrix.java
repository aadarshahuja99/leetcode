class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        int[][][] cache = new int[m][n][9];
        for(int[][] outerRow : cache)
        {
            for(int[] row : outerRow)
            {
                Arrays.fill(row, -1);
            }
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(mat[i][j] == 1)
                {
                    int candidate = getLongestLineLength(i, j, 0, mat, m, n, cache);
                    if(candidate == 0)
                    {
                        candidate = 1;
                    }
                    ans = Math.max(ans, getLongestLineLength(i, j, 0, mat, m, n, cache));
                }
            }
        }
        return ans;
    }
    private int getLongestLineLength(int row, int col, int direction, int[][] mat, int m, int n, int[][][] cache)
    {
        int length = 1;
        int[] deltaRow = new int[] { 1,0,-1,0,1,1,-1,-1 };
        int[] deltaCol = new int[] { 0,1,0,-1,-1,1,1,-1 };
        if(cache[row][col][direction] != -1)
        {
            return cache[row][col][direction];
        }
        if(direction == 0)
        {
            for(int i=0; i<8; i++)
            {
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                if(validate(newRow, newCol, m, n, mat))
                {
                    length = Math.max(1 + getLongestLineLength(newRow, newCol, i+1, mat, m, n, cache), length);
                }
            }
            return cache[row][col][direction] = length;
        }
        else
        {
            int newRow = row + deltaRow[direction-1];
            int newCol = col + deltaCol[direction-1];
            if(validate(newRow, newCol, m, n, mat))
            {
                return cache[row][col][direction] = (1 + getLongestLineLength(newRow, newCol, direction, mat, m, n, cache));
            }
        }
        return cache[row][col][direction] = 1;
    }
    private boolean validate(int row, int col, int m, int n, int[][] mat)
    {
        return row >= 0 && row < m && col >= 0 && col < n && mat[row][col] == 1;
    }
}