class Solution {
    static final int MODULO = 1000000007;
    public int countHousePlacements(int n) {
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        int placeForOneRow = findWays(0, n, cache);
        return (int)(((long)(placeForOneRow)*placeForOneRow)%MODULO);
    }
    // fibonacci type recurrence when you think about it
    private int findWays(int current, int n, int[] cache)
    {
        if(current >= n)
        {
            return 1;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        return cache[current] = (findWays(current+1, n, cache)%MODULO + findWays(current+2, n, cache)%MODULO)%MODULO;
    }
}