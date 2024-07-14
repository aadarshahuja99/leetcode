class Solution {
    int ans = 0;
    public int countPyramids(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache1 = new int[m][n];
        int[][] cache2 = new int[m][n];
        for(int[] r : cache1)
        {
            Arrays.fill(r, -1);
        }
        for(int[] r : cache2)
        {
            Arrays.fill(r, -1);
        }
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(cache1[i][j] != -1)
                {
                    continue;
                }
                getAns(i, j, grid, cache1);
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(cache2[i][j] != -1)
                {
                    continue;
                }
                getAns1(i, j, grid, cache2);
            }
        }

        return ans;
    }
    private int getAns(int r, int c, int[][] grid, int[][] cache)
    {
        int n = grid[0].length;
        int m = grid.length;
        
        if(r == m || c == n || r < 0 || c < 0)
        {
            return 0;
        }
        if(cache[r][c] != -1)
        {
            return cache[r][c];
        }
        int bottom = getAns(r+1, c, grid, cache);
        int left = getAns(r+1, c-1, grid, cache);
        int right = getAns(r+1, c+1, grid, cache);
        // System.out.println(bottom+" "+left+" "+right+" for "+r+","+c);
        if(grid[r][c] == 1)
        {
            int min = Math.min(bottom, Math.min(left, right));
            if(min > 0)
            {
                ans += min;
            }
            return cache[r][c] = 1 + min;
        }
        return cache[r][c] = 0;
    }

    private int getAns1(int r, int c, int[][] grid, int[][] cache)
    {
        int n = grid[0].length;
        int m = grid.length;
        if(r == m || c == n || r < 0 || c < 0)
        {
            return 0;
        }
        if(cache[r][c] != -1)
        {
            return cache[r][c];
        }

        int top = getAns(r-1, c, grid, cache);
        int left = getAns(r-1, c-1, grid, cache);
        int right = getAns(r-1, c+1, grid, cache);
        
        if(grid[r][c] == 1)
        {
            int min = Math.min(top, Math.min(left, right));
            if(min > 0)
            {
                ans += min;
            }
            return cache[r][c] = 1 + min;
        }
        return cache[r][c] = 0;
    }
}