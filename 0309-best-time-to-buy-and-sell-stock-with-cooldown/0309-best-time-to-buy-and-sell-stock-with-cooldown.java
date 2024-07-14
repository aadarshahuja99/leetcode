class Solution {
    public int maxProfit(int[] prices) {
        int[][] cache = new int[prices.length+1][2];
        for(int[] row : cache)
        {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return getAns(0, 1, prices, cache);
    }
    private int getAns(int current, int canBuy, int[] prices, int[][] cache)
    {
        if(current >= prices.length)
        {
            return canBuy == 1 ? 0 : -5000001;
        }
        if(cache[current][canBuy] != Integer.MIN_VALUE)
        {
            return cache[current][canBuy];
        }
        int skip = getAns(current+1, canBuy, prices, cache);
        if(canBuy == 1)
        {
            int buy = -prices[current] + getAns(current+1, 0, prices, cache);
            return cache[current][canBuy] =  Math.max(buy, skip);
        }
        else
        {
            int sell = prices[current] + getAns(current+2, 1, prices, cache);
            return cache[current][canBuy] = Math.max(sell, skip);
        }
    }
}