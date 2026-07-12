class Solution {
    int MOD = 1_000_000_007;
    public int numOfWays(int n) {
        int[][][][] cache = new int[n][4][4][4];
        for(int[][][] nnr: cache)
        {
            for(int[][] nr : nnr)
            {
                for(int[] r : nr)
                {
                    Arrays.fill(r, -1);
                }
            }
        }
        return getAns(0, 0, 0, 0, n, cache);
    }
    private int getAns(int r, int p1, int p2, int p3, int n, int[][][][] cache)
    {
        if(r == n)
        {
            return 1;
        }
        if(cache[r][p1][p2][p3] != -1)
        {
            return cache[r][p1][p2][p3];
        }
        int ans = 0;
        for(int i=1; i<=3; i++)
        {
            for(int j = 1; j<=3; j++)
            {
                for(int k=1; k<=3; k++)
                {
                    if(i == j || j == k)
                    {
                        continue;
                    }
                    if(i!=p1 && j!= p2 && k != p3)
                    {
                        ans = (ans%MOD + getAns(r+1, i, j, k, n, cache)%MOD)%MOD;
                    }
                }
            }
        }
        return cache[r][p1][p2][p3] = ans;
    }
}