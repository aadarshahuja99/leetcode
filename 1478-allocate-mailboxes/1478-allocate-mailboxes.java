class Solution { // 13 ms, faster than 57.37%
    public final int MAX = 100, INF = 100 * 10000; // maximum distance = N * MAX_POS = 100 * 10^4 = 10^6
    int[][] costs = new int[MAX][MAX];
    Integer[][] memo = new Integer[MAX][MAX];
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int medianPos = houses[(i + j) / 2];
                for (int m = i; m <= j; m++)
                    costs[i][j] += Math.abs(medianPos - houses[m]);
            }
        }
        return dp(houses, n, k, 0);
    }
    int dp(int[] houses, int n, int k, int i) {
        if (k == 0 && i == n) return 0;
        if (k == 0 || i == n) return INF;
        if (memo[k][i] != null) return memo[k][i];
        int ans = INF;
        for (int j = i; j < n; j++)
            ans = Math.min(ans, costs[i][j] + dp(houses, n, k-1, j + 1));
        return memo[k][i] = ans;
    }
}