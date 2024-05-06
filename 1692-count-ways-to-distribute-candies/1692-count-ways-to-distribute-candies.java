class Solution {
    int MOD = 1000000007;
    public int waysToDistribute(int n, int k) {
        int[][] cache = new int[n+1][k+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getWays(k, n, cache);
    }
    private int getWays(int currentBags, int n, int[][] cache)
    {
        // fill the bags sequentially but also think of assigning the current candy to any of the previous bags
        // 2 choices: assign to previous bags or assign to a new bag
        // not a bit masking dp question
        if(n == 0 && currentBags == 0)
        {
            return 1;
        }
        if(n == 0 || currentBags == 0)
        {
            return 0;
        }
        if(cache[n][currentBags] != -1)
        {
            return cache[n][currentBags];
        }
        return cache[n][currentBags] = (getWays(currentBags-1, n-1, cache)%MOD + (int)((long)(currentBags)*getWays(currentBags, n-1, cache)%MOD))%MOD;
    }
}