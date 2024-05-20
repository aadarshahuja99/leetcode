class Solution {
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] cache = new int[high+1];
        Arrays.fill(cache, -1);
        return getAns(0, low, high, zero, one, cache);
    }
    private int getAns(int current, int low, int high, int zero, int one, int[] cache)
    {
        int ways = 0;
        if(cache[current] != -1)
        {
            return cache[current];
        }
        if(current >= low && current <= high)
        {
            ways++;
        }
        if(zero + current <= high)
        {
            ways = (ways%mod + getAns(current + zero, low, high, zero, one, cache)%mod)%mod;
        }
        if(one + current <= high)
        {
            ways = (ways%mod + getAns(current + one, low, high, zero, one, cache)%mod)%mod;
        }
        return cache[current] = ways;
    }
}