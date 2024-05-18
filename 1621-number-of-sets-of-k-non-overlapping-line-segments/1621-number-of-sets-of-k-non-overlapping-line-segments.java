class Solution {
    int mod = 1000000007;
    public int numberOfSets(int n, int k) {
        int[][][] cache = new int[n+1][k+1][2];
        for(int[][] parentRow : cache)
        {
            for(int[] row : parentRow)
            {
                Arrays.fill(row, -1);
            }
        }
        return getAns(0, 0, k, n, cache);
    }
    private int getAns(int currentPosition, int hasStarted, int k, int n, int[][][] cache)
    {
        if(currentPosition >= n)
        {
            if(k == 0)
            {
                return 1;
            }
            return 0;
        }
        if(k == 0)
        {
            return 1;
        }
        if(cache[currentPosition][k][hasStarted] != -1)
        {
            return cache[currentPosition][k][hasStarted];
        }
        if(hasStarted == 1)
        {
            // can start a new segment or continue the current segment
            return cache[currentPosition][k][hasStarted] = (getAns(currentPosition+1, 1, k, n, cache)%mod + getAns(currentPosition, 0, k-1, n, cache)%mod)%mod;
        }
        // can skip the current point OR start a new segment from the current point
        return cache[currentPosition][k][hasStarted] = (getAns(currentPosition+1, 1, k, n, cache)%mod + getAns(currentPosition+1, 0, k, n, cache)%mod)%mod;
    }
}