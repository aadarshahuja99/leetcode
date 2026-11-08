class Solution {
        public int maxSumRangeQuery(int[] A, int[][] req) {
        long res = 0, mod = (long)1e9 + 7;
        int n = A.length, count[] = new int[n+1];
        for (int[] r: req) {
            count[r[0]] += 1;
            count[r[1] + 1] -= 1;
        }
        // count[i] represents number of requests of which each 'i' is a part
        for (int i = 1; i <= n; i++)
        {
            count[i] += count[i - 1];
        }
        Arrays.sort(A);
        Arrays.sort(count, 0, n);
        for (int i = 0; i < n; i++)
        {
            res += (long)A[i] * count[i];
        }
        return (int)(res % mod);
    }
}