class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] cache = new int[n+1][2][k+1];
        for(int i=n-1; i>=0; i--)
        {
            for(int canBuy = 0; canBuy <= 1; canBuy++)
            {
                for(int t = k-1; t >= 0; t--)
                {
                    int buy = 0;
                    int sell = 0;
                    if(canBuy == 1 && t < k)
                    {
                        buy = -1*prices[i] + cache[i+1][0][t];
                    }
                    else if(canBuy == 0 && t < k)
                    {
                        sell = prices[i] + cache[i+1][1][t+1];
                    }
                    cache[i][canBuy][t] = Math.max(cache[i+1][canBuy][t], Math.max(buy, sell));
                }
            }
        }
        return cache[0][1][0];
    }
}