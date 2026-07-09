class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int ans = 0;
        int n = prices.length;
        for(int i=1; i<n; i++)
        {
            ans = Math.max(ans, prices[i] - minSoFar);
            minSoFar = Math.min(prices[i], minSoFar);
        }
        return ans;
    }
}