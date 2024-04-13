class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int[] row : dp)
        {
            Arrays.fill(row, -1);
        }
        int ans = getAns(0,arr.length-1,arr, dp);
        return ans;
    }
    private int getAns(int i, int j, int[] arr, int[][] dp)
    {
        if(i >= j)
        {
            return 0;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++)
        {
            int maxLeft = getMax(i, k, arr);
            int maxRight = getMax(k+1, j, arr);
            ans = Math.min(ans, maxLeft*maxRight + getAns(i, k, arr, dp) + getAns(k+1, j, arr, dp));
        }
        return dp[i][j] = ans;
    }
    private int getMax(int i, int j, int[] arr)
    {
        int max = 0;
        for(int it=i; it<=j; it++)
        {
            max=Math.max(arr[it], max);
        }
        return max;
    }
}