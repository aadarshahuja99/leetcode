class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        // any of the corner starting people can not cross the diagonal line
        int ans = 0;
        int n = fruits.length;
        for(int i=0; i<n; i++)
        {
            ans += fruits[i][i];
        }
        int[][] c1 = new int[n][n];
        int[][] c2 = new int[n][n];
        for(int[] row : c1)
        {
            Arrays.fill(row, -1);
        }
        for(int[] row : c2)
        {
            Arrays.fill(row, -1);
        }
        ans += getMax(0, n-1, n, fruits, new int[][] { {1, 0}, {1, -1}, {1, 1} }, c1, 1)
        + getMax(n-1, 0, n, fruits, new int[][] { {0, 1}, {1, 1}, {-1, 1} }, c2, 2);
        // System.out.println(c1[0][n-1] + " " + c2[n-1][0]);
        return ans;
    }
    private int getMax(int r, int c, int n, int[][] grid, int[][] nextMoves, int[][] cache, int dice)
    {
        if(dice == 1 && r >= c)
        {
            return 0;
        }
        if(dice == 2 && c >= r)
        {
            return 0;
        }
        if(cache[r][c] != -1)
        {
            return cache[r][c];
        }
        int ans = 0;
        for(int[] dir : nextMoves)
        {
            int nR = r + dir[0];
            int nC = c + dir[1];
            if(nR < 0 || nR > n-1 || nC < 0 || nC > n-1)
            {
                continue;
            }
            // System.out.println(r+" "+c);
            ans = Math.max(ans, grid[r][c] + getMax(nR, nC, n, grid, nextMoves, cache, dice));
        }
        return cache[r][c] = ans;
    }
}