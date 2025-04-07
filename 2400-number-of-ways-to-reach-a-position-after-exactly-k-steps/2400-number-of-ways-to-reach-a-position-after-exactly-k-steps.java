class Solution {
    int mod = 1000000007;
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] cache = new int[startPos+2*k+1][k+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(startPos + k, k, endPos, k, cache);
    }
    private int getAns(int currentPos, int steps, int end, int k, int[][] cache)
    {
        if(steps == 0)
        {
            return currentPos == end + k ? 1 : 0;
        }
        if(cache[currentPos][steps] != -1)
        {
            return cache[currentPos][steps];
        }
        return cache[currentPos][steps] = (getAns(currentPos + 1, steps - 1, end, k, cache)%mod + getAns(currentPos - 1, steps - 1, end, k, cache)%mod)%mod;
    }
}