class Solution {
    // public int maxSumRangeQuery(int[] nums, int[][] requests) {
    //     Arrays.sort(requests, (a, b) -> {
    //         return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
    //     });
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     int[] counts = new int[n+1];
    //     for(int[] req : requests)
    //     {
    //         counts[req[0]]++;
    //         counts[req[1] + 1]--;
    //     }
    //     int total = 0;
    //     for(int i=1; i<n; i++)
    //     {
    //         counts[i] += counts[i-1];
    //     }
    //     Arrays.sort(counts);
    //     long ans = 0l;
    //     int mod = 1_000_000_007;
    //     int it = 0;
    //     while(it < n)
    //     {
    //         // System.out.println(pq.peek()+" "+counts[it]);
    //         ans = (ans%mod + (((1l*counts[it]))*((nums[it]*1l)))%mod)%mod;
    //         it++;
    //     }
    //     return (int)ans;
    // }

        public int maxSumRangeQuery(int[] A, int[][] req) {
        long res = 0, mod = (long)1e9 + 7;
        int n = A.length, count[] = new int[n+1];
        for (int[] r: req) {
            count[r[0]] += 1;
            count[r[1] + 1] -= 1;
        }
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