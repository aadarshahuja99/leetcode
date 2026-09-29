class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] cache = new int[n][n][n];
        for (int[][] layer: cache) {
            for (int[] row: layer) {
                Arrays.fill(row, -1);
            }
        }
        return Math.max(0, getAns(0, 0, 0, cache, grid));
    }
    public int getAns(int r1, int c1, int c2, int[][][] cache, int[][] grid) {
        int r2 = r1 + c1 - c2;
        int n = grid.length;
        if (n == r1 || n == r2 || n == c1 || n == c2 ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == n - 1 && c1 == n - 1) {
            return grid[r1][c1];
        }
        if (cache[r1][c1][c2] != -1) {
            return cache[r1][c1][c2];
        }
        int ans = grid[r1][c1];
        if (c1 != c2) {
            ans += grid[r2][c2];
        }
        ans += Math.max(Math.max(getAns(r1, c1 + 1, c2 + 1, cache, grid), getAns(r1 + 1, c1, c2 + 1, cache, grid)),
                        Math.max(getAns(r1, c1 + 1, c2, cache, grid), getAns(r1 + 1, c1, c2, cache, grid)));
        return cache[r1][c1][c2] = ans;
    }
}