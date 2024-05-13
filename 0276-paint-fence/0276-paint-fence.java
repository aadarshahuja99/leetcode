class Solution {
    public int numWays(int n, int k) {
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);
        return findWays(n, k, n, cache);
    }
    private int findWays(int currentFence, int k, int n, int[] cache)
    {
        if(currentFence == 1)
        {
            return k;
        }
        if(currentFence == 2)
        {
            return k*k;
        }
        if(cache[currentFence] != -1)
        {
            return cache[currentFence];
        }
        return cache[currentFence] = (k-1)*(findWays(currentFence-1, k, n, cache) + findWays(currentFence - 2, k, n, cache));
    }
}