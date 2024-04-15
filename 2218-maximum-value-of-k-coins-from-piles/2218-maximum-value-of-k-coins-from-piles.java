class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()][k+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return getMaxCoins(0, k, piles, dp);
    }
    private int getMaxCoins(int currentStackIndex, int rem, List<List<Integer>> piles, int[][] dp)
    {
        if(rem == 0 || currentStackIndex == piles.size())
        {
            return 0;
        }
        if(dp[currentStackIndex][rem] != -1)
        {
            return dp[currentStackIndex][rem];
        }
        int ans = getMaxCoins(currentStackIndex+1, rem, piles, dp);
        int temp = 0;
        var currentPile = piles.get(currentStackIndex);
        for(int i=0; i < Math.min(currentPile.size(), rem); i++)
        {
            temp += currentPile.get(i);
            ans = Math.max(ans, temp + getMaxCoins(currentStackIndex+1, rem-i-1, piles, dp));
        }
        return dp[currentStackIndex][rem] = ans;
    }
}