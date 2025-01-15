class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        return getAns(1, n, dp);
    }
    private int getAns(int start, int end, int[][] dp)
    {
        if(start >= end)
        {
            return 0;
        }
        if(dp[start][end] != -1)
        {
            return dp[start][end];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=start; k<=end; k++)
        {
            ans = Math.min(ans, k + Math.max(getAns(start, k-1, dp), getAns(k+1, end, dp)));
        }
        // System.out.println(ans+" for "+start+","+end);
        return dp[start][end] = ans;
    }
}