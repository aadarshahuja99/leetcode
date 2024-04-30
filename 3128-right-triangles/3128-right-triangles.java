class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowCount = new int[n];
        int[] columnCount = new int[m];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    rowCount[i]++;
                    columnCount[j]++;
                }
            }
        }

        long ans = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    ans += 1L*(rowCount[i] - 1)*(columnCount[j]-1);
                }
            }
        }
        return ans;
    }
}