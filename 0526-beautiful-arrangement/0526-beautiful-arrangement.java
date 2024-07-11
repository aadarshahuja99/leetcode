class Solution {
    public int countArrangement(int n) {
        int maxState = (int)Math.pow(2, 15);
        int[][] cache = new int[n+1][maxState];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(1, maxState - 1, n, cache);
    }
    private int getAns(int current, int state, int n, int[][] cache)
    {
        if(current == n+1)
        {
            return 1;
        }
        if(cache[current][state] != -1)
        {
            return cache[current][state];
        }
        int ans = 0;
        for(int i=1; i<=n; i++)
        {
            int idx = i-1;
            if((state&(1<<idx)) > 0 && (i%current == 0 || current%i == 0))
            {
                ans += getAns(current+1, state^(1<<idx), n, cache);
            }
        }
        return cache[current][state] = ans;
    }
}