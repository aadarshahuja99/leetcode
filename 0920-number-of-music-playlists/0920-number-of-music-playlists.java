class Solution {
    int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        int[][] cache = new int[goal+1][n+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, n, goal, k, cache);
    }
    private int getAns(int current, int uniquePlayed, int n, int goal, int k, int[][] cache)
    {
        if(current == goal && uniquePlayed == n)
        {
            return 1;
        }
        if(current == goal)
        {
            return 0;
        }
        if(cache[current][uniquePlayed] != -1)
        {
            return cache[current][uniquePlayed];
        }
        if(uniquePlayed > k)
        {
            int repeat = (int)(1L*((uniquePlayed - k)%mod)*(1L*getAns(current+1, uniquePlayed, n, goal, k, cache)%mod)%mod);
            if(uniquePlayed < n)
            {
                int addNew = (int)((1L*(n - uniquePlayed)%mod)*(1L*getAns(current+1, uniquePlayed+1, n, goal, k, cache))%mod)%mod;
                return cache[current][uniquePlayed] = (int)(addNew%mod + repeat%mod)%mod;
            }
            return cache[current][uniquePlayed] = repeat;
        }
        return cache[current][uniquePlayed] = (int)(((1L*(n - uniquePlayed)%mod))*(1L*getAns(current+1, uniquePlayed+1, n, goal, k, cache)%mod)%mod);
    }
}