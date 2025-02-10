class Solution {
    int MOD = 1_000_000_007;
    int[][] cache;
    public int numberOfWays(int n, int x, int y) {
        cache = new int[n][x+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, n, x, y);
    }
    private int getAns(int currentPerformer, int assigned, int n, int x, int y)
    {
        if(currentPerformer == n)
        {
            return getExponentVal(y, assigned);
        }
        if(cache[currentPerformer][assigned] != -1)
        {
            return cache[currentPerformer][assigned];
        }
        if(assigned < x)
        {
            return cache[currentPerformer][assigned] = (int)(( (1l*(x-assigned)*getAns(currentPerformer+1, assigned+1, n, x, y))%MOD + (1l*assigned*getAns(currentPerformer+1, assigned, n, x, y))%MOD )%MOD);
        }
        return cache[currentPerformer][assigned] = (int)((1l*x*getAns(currentPerformer+1, assigned, n, x, y))%MOD);
    }
    // computes y^x using binary exponentiation
    private int getExponentVal(int y, int x)
    {
        if(x == 0)
        {
            return 1;
        }
        int v = getExponentVal(y, x/2);
        if(x%2 == 1)
        {
            return (int)(( ((1l*y*v)%MOD) *v)%MOD);
        }
        return (int)( (1l*v*v)%MOD );
    }
}