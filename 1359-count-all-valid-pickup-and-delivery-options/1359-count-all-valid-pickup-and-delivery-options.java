class Solution {
    int mod = 1000000007;
    public int countOrders(int n) {
        int[][] cache = new int[n+1][n];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, n, cache);
    }
    private int getAns(int active, int fulfilled, int n, int[][] cache)
    {
        if(fulfilled == n)
        {
            return 1;
        }
        if(cache[active][fulfilled] != -1)
        {
            return cache[active][fulfilled];
        }
        if(active > 0)
        {
            int end = multiplyLargeIntegers(active, getAns(active-1, fulfilled+1, n, cache));
            if(active < n)
            {
                int remaining = n - fulfilled - active;
                int addAnother = multiplyLargeIntegers(remaining, getAns(active+1, fulfilled, n, cache));
                return cache[active][fulfilled] = (end%mod  + addAnother%mod)%mod;
            }
            return cache[active][fulfilled] = end;
        }
        return cache[active][fulfilled] = multiplyLargeIntegers(n - fulfilled, getAns(active+1, fulfilled, n, cache));
    }
    private int multiplyLargeIntegers(int num1, int num2)
    {
        return (int)(((long)(num1%mod)*(num2%mod))%mod);
    }
}