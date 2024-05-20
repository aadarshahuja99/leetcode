class Solution {
    int mod = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] cache = new int[locations.length][fuel+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(start, fuel, finish, locations, cache);
    }
    private int getAns(int current, int fuel, int finish, int[] locations, int[][] cache)
    {
        if(fuel == 0)
        {
            return current == finish ? 1 : 0;
        }
        if(cache[current][fuel] != -1)
        {
            return cache[current][fuel];
        }
        int ans = 0;
        if(current == finish)
        {
            ans++;
        }
        int n = locations.length;
        for(int i=0; i<n; i++)
        {
            if(i == current)
            {
                continue;
            }
            int cost = Math.abs(locations[i] - locations[current]);
            if(cost <= fuel)
            {
                ans = (ans%mod + getAns(i, fuel-cost, finish, locations, cache)%mod)%mod;
            }
        }
        return cache[current][fuel] = ans;
    }
}