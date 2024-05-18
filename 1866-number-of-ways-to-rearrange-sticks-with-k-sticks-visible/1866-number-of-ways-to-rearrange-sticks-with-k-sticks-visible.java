class Solution {
    int mod = 1000000007;
    public int rearrangeSticks(int n, int k) {
        int[][] cache = new int[n+1][k+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(n, k, cache);
    }
    private int getAns(int toBeSelected, int remainingSticks, int[][] cache)
    {
        if(toBeSelected == 0)
        {
            return remainingSticks == 0 ? 1 : 0;
        }
        if(remainingSticks == 0)
        {
            return 0;    
        }
        if(cache[toBeSelected][remainingSticks] != -1)
        {
            return cache[toBeSelected][remainingSticks];
        }
        return cache[toBeSelected][remainingSticks] = (getAns(toBeSelected-1, remainingSticks-1, cache)%mod + (int)(((long)(toBeSelected-1)*getAns(toBeSelected-1, remainingSticks, cache))%mod))%mod;
    }
}