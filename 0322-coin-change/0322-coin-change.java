class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] cache = new int[coins.length][amount+1];
        for(int[] row : cache)
        {
            Arrays.fill(row, -1);
        }
        int ans = getAns(0, amount, coins, cache);
        if(ans == Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
    private int getAns(int current, int target, int[] coins, int[][] cache)
    {
        if(current == coins.length)
        {
            if(target == 0)
            {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(target == 0)
        {
            return 0;
        }
        if(cache[current][target] != -1)
        {
            return cache[current][target];
        }
        int notTake = getAns(current+1, target, coins, cache);
        if(coins[current] <= target)
        {
            int take = getAns(current, target-coins[current], coins, cache);
            if(take != Integer.MAX_VALUE)
            {
                take += 1;
            }
            return cache[current][target] = Math.min(take, notTake);
        }
        return cache[current][target] = notTake;
    }
}