class Solution {
    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][][] cache = new int[profit.length][n+1][minProfit+1];
        for(int[][] outer : cache)
        {
            for(int[] row : outer)
            {
                Arrays.fill(row, -1);
            }
        }
        return getWays(0, 0, 0, group, profit, minProfit, n, cache);
    }
    private int getWays(int currentCrime, int peopleSelected, int profitSoFar, int[] group, int[] profit, int minProfit, int n, int[][][] cache)
    {
        if(currentCrime == profit.length)
        {
            return profitSoFar == minProfit ? 1 : 0;
        }
        if(cache[currentCrime][peopleSelected][profitSoFar] != -1)
        {
            return cache[currentCrime][peopleSelected][profitSoFar];
        }
        int ways = getWays(currentCrime+1, peopleSelected, profitSoFar, group, profit, minProfit, n, cache);
        if(group[currentCrime] <= n-peopleSelected)
        {
            ways = (ways%mod + getWays(currentCrime+1, peopleSelected + group[currentCrime], Math.min(minProfit, profitSoFar + profit[currentCrime]), group, profit, minProfit, n, cache)%mod)%mod;
        }
        return cache[currentCrime][peopleSelected][profitSoFar] = ways;
    }
}