class Solution {
    public int countArrangement(int n) {
        int[][] cache = new int[n+1][(1<<n)];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        return getAns(1, 0, n, cache);
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
            if((state&(1<<(i-1))) == 0 && (current%i == 0 || i%current == 0))
            {
                ans = ans + getAns(current+1, (state|(1<<(i-1))), n, cache);
            }
        }
        return cache[current][state] = ans;
    }
}