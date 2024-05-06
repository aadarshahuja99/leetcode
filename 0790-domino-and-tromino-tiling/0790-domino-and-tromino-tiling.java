class Solution {
    static final int MOD = 1000000007;
    public int numTilings(int n) {
        int[][] cache = new int[n][2];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return findWays(0, 0, n, cache);
    }
    private int findWays(int columnIndex, int mask, int n, int[][] cache)
    {
        if(columnIndex == n)
        {
            return mask == 0 ? 1 : 0;
        }
        if(columnIndex > n)
        {
            return 0;
        }
        if(cache[columnIndex][mask] != -1)
        {
            return cache[columnIndex][mask];
        }
        if(mask == 0)
        {
            int L = (int)(((long)2*(long)findWays(columnIndex+1, 1, n, cache))%MOD);
            int vertical = findWays(columnIndex+1, 0, n, cache);
            int horizontal = findWays(columnIndex+2, 0, n, cache);
            // System.out.println(columnIndex+" "+mask+" "+L+" "+vertical+" "+horizontal);
            return cache[columnIndex][mask] = ((L%MOD + vertical%MOD)%MOD + horizontal%MOD)%MOD;
        }
        else
        {
            int L = findWays(columnIndex+2, 0, n, cache);
            int horizontal = findWays(columnIndex+1, 1, n, cache);
            // System.out.println(columnIndex+" "+mask+" "+L+" "+horizontal);
            return cache[columnIndex][mask] = (L%MOD + horizontal%MOD)%MOD;
        }
    }
}