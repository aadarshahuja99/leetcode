class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] cache = new int[n][2];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        return getAns(0, 0, prices, cache);
    }
    private int getAns(int currentDay, int isActive, int[] prices, int[][] cache)
    {
        if(currentDay == prices.length)
        {
            return 0;
        }
        if(cache[currentDay][isActive] != -1)
        {
            return cache[currentDay][isActive];
        }
        int sell = 0;
        int buy = 0;
        int hold = getAns(currentDay+1, isActive, prices, cache);
        if(isActive == 0)
        {
            buy = -prices[currentDay] + getAns(currentDay+1, 1, prices, cache);
        }
        else
        {
            sell = prices[currentDay] + getAns(currentDay+1, 0, prices, cache);
        }
        return cache[currentDay][isActive] = Math.max(hold, Math.max(buy, sell));
    }
}