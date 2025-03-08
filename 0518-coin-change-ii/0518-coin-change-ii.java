class Solution {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount+1];
        for(int[] r : cache)
        {
            Arrays.fill(r, -1);
        }
        return getAns(0, amount, coins, cache);
    }
    private int getAns(int current, int target, int[] coins, int[][] cache)
    {
        if(current == coins.length)
        {
            if(target == 0)
            {
                return 1;
            }
            return 0;
        }
        if(cache[current][target] != -1)
        {
            return cache[current][target];
        }
        int notTake = getAns(current+1, target, coins, cache);
        if(coins[current] <= target)
        {
            int take = getAns(current, target - coins[current], coins, cache);
            return cache[current][target] = take + notTake;
        }
        return cache[current][target] = notTake;
    }
}