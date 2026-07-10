
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] cache = new int[m][n];
        // for(int[] row : cache)
        // {
        //     Arrays.fill(row, -1);
        // }
        
        // bottom up
        cache[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 0 : dungeon[m-1][n-1];
        for(int i=m-1; i>=0; i--)
        {
            for(int j=n-1; j>=0; j--)
            {
                if(i == m-1 && j == n-1)
                {
                    continue;
                }
                int[][] delta = {{0,1},{1,0}};
                int currentMax = Integer.MIN_VALUE;
                for(int[] d : delta)
                {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n)
                    {
                        currentMax = Math.max(currentMax, dungeon[i][j] + cache[nr][nc]);
                    }
                }
                cache[i][j] = currentMax > 0 ? 0 : currentMax;
            }
        }
        return Math.abs(cache[0][0]) + 1;
    }
    private int getAns(int row, int col, int m, int n, int[][] dungeon, int[][] cache)
    {
        if(row == m-1 && col == n-1)
        {
            return dungeon[row][col] > 0 ? 0 : dungeon[row][col];
        }
        if(row >= m || col >= n)
        {
            return Integer.MIN_VALUE;
        }
        if(cache[row][col] != -1)
        {
            return cache[row][col];
        }
        int right = getAns(row, col+1, m, n, dungeon, cache);
        int down = getAns(row+1, col, m, n, dungeon, cache);
        int current = Math.max(down, right) + dungeon[row][col];
        return cache[row][col] = current > 0 ? 0 : current;
    }
}