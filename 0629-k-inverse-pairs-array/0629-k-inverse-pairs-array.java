class Solution {
    private final int MOD = (int) (1e9 + 7);
    private Integer dp[][];

    public int kInversePairs(int n, int k) {
        dp = new Integer[n + 1][k + 1];

        return getInversions(n, k);
    }

    private int getInversions(int n, int k) {
        if (n == 0) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (dp[n][k] != null) {
            return dp[n][k];
        }

        int ans = 0;
        // placing the current max element in any of the available n slots, if placed in nth one, 0 new inversions will be added. Similarly if added in n-1th one, 1 new inversion will be added and so on. We can only allow upto k inversions max for the current element
        for (int inversion = 0; inversion <= Math.min(k, n - 1); inversion++) {
            ans = (ans + getInversions(n - 1, k - inversion))%MOD;
        }

        return dp[n][k] = ans;
    }
}