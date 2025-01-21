class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] pre = new long[n];
        long[] suf = new long[n];
        pre[0] = grid[0][0];
        suf[n-1] = grid[1][n-1];
        for(int i=1; i<n; i++)
        {
            pre[i] = pre[i-1] + grid[0][i];
            suf[n-i-1] = suf[n-i] + grid[1][n-i-1];
            // System.out.println(pre[i]+" "+suf[n-i-1]);
        }
        long ans = Long.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            // System.out.println(total+" "+pre[i]+" "+suf[i]);
            ans = Math.min(ans, Math.max(pre[n-1] - pre[i], suf[0] - suf[i]));
        }
        return ans;
    }
}