class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        return getAns(0, n, cache);
    }
    private int getAns(int index, int n, int[] cache)
    {
        if(index == n)
        {
            return 1;
        }
        if(cache[index] != -1)
        {
            return cache[index];
        }
        int oneStep = getAns(index+1, n, cache);
        if(index+2 <= n)
        {
            int twoStep = getAns(index+2, n, cache);
            return cache[index] = oneStep + twoStep;
        }
        return cache[index] = oneStep;
    }
}