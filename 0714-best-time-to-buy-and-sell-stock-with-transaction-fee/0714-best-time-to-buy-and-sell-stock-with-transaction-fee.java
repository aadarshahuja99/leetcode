class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] cache = new int[n+1][2];
        for(int i=n-1; i>=0; i--)
        {
            for(int canBuy = 0; canBuy <= 1; canBuy++)
            {
                int buy = 0;
                int sell = 0;
                if(canBuy == 1)
                {
                    buy = -1*prices[i] + cache[i+1][0];
                }
                else if(canBuy == 0)
                {
                    sell = prices[i] - fee + cache[i+1][1];
                }
                cache[i][canBuy] = Math.max(cache[i+1][canBuy], Math.max(buy, sell));
            }
        }
        return cache[0][1];
    }
}