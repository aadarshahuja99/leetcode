class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int[][] cache = new int[mat.length][343001];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getMinDifference(0, 0, target, mat, cache);
    }
    private int getMinDifference(int row, int currentTotal, int target, int[][] mat, int[][] cache)
    {
        // tip: it is not necessary to only cache indexes. Non index params that affect the answer can also be cached
        if(row == mat.length)
        {
            return Math.abs(currentTotal - target);
        }
        if(cache[row][currentTotal] != -1)
        {
            return cache[row][currentTotal];
        }
        int min = 343000;
        for(int i=0; i<mat[0].length; i++)
        {
            min = Math.min(min, getMinDifference(row+1, currentTotal + mat[row][i], target, mat, cache));
        }
        return cache[row][currentTotal] = min;
    }
}