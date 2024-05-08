
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] cache = new int[m][n];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return Math.abs(getAns(0,0,m,n,dungeon,cache)) + 1;
    }
    private int getAns(int row, int col, int m, int n, int[][] dungeon, int[][] cache)
    {
        if(row == m-1 && col == n-1)
        {
            return dungeon[row][col] > 0 ? 0 : dungeon[row][col];
        }
        if(row >= m || col >= n)
        {
            return -1000001;
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