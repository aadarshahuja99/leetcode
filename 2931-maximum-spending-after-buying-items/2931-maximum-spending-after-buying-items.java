class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length;
        int n = values[0].length;
        long[] vals = new long[m*n];
        int idx = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                vals[idx] = values[i][j];
                idx++;
            }
        }
        long ans = 0;
        Arrays.sort(vals);
        for(int i=1; i<=m*n; i++)
        {
            ans += (long)i*vals[i-1];
        }
        return ans;
    }
}