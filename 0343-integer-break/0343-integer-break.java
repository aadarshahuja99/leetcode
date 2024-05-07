class Solution {
    public int integerBreak(int n) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return getMaxProduct(n, n, cache);
    }
    private int getMaxProduct(int n, int initialNumber, int[] cache)
    {
        if(n == 1)
        {
            return 1;
        }
        if(cache[n] != -1)
        {
            return cache[n];
        }
        int ans = 0;
        for(int i=1; i<n; i++)
        {
            ans = Math.max(ans, i*getMaxProduct(n-i, initialNumber, cache));
        }
        if(n != initialNumber)
        {
            return cache[n] = Math.max(ans, n);
        }
        return cache[n] = ans;
    }
}