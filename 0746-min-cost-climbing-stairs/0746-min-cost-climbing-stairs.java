class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] cache = new int[n];
        Arrays.fill(cache, -1);
        getAns(0, cost, cache);
        return Math.min(cache[0], cache[1]);
    }
    private int getAns(int current, int[] cost, int[] cache)
    {
        if(current >= cost.length)
        {
            return 0;
        }
        if(cache[current] != -1)
        {
            return cache[current];
        }
        return cache[current] = cost[current] + Math.min(getAns(current+1, cost, cache), getAns(current+2, cost, cache));
    }
}