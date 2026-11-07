class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        cache[n] = 1;
        for(int i=n-1; i>=0; i--)
        {
            cache[i] = cache[i+1];
            if(i <= n-2)
            {
                cache[i] += cache[i+2];
            }
        }
        return cache[0];
    }
}