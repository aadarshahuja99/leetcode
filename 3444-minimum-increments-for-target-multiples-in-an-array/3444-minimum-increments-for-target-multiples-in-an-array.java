class Solution {
    static public int minimumIncrements(int[] nums, int[] target) {
        Long[][] dp = new Long[nums.length + 1][(1 << target.length)];
        long ans = solve(0, nums, target, 0, dp);
        return (int) ans;
    }

    static long solve(int i, int[] arr, int[] target, int mask, Long[][] dp) {
        int want = (1 << target.length) - 1;
        if (dp[i][mask] != null) {
            return dp[i][mask];
        }

        if (i == arr.length) {
            if (mask == want) return 0;
            return 100000;
        }

        int current = want & ~mask;
        long ans = 100000, min = 100000;

        for (int j = current; j > 0; j = ((j - 1) & current)) {
            long lcm = LCM(j, target);
            long x = (long) (Math.ceil(arr[i] / (lcm * 1.0)));
            ans = ((lcm * x) - arr[i]) + solve(i + 1, arr, target, mask | j, dp);
            min = Math.min(min, ans);
        }

        long notConsider = solve(i + 1, arr, target, mask, dp);
        long result = Math.min(min, notConsider);
        dp[i][mask] = result;
        return result;
    }

    static long LCM(int mask, int[] target) {
        ArrayList<Long> l = new ArrayList<>();
        for (int i = 0; i < target.length; i++) {
            if ((mask & (1 << i)) != 0) {
                l.add((long) target[i]);
            }
        }

        if (l.size() == 1) return l.get(0);

        long lcm = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            lcm = (lcm * l.get(i)) / gcd(lcm, l.get(i));
        }
        return lcm;
    }

    static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}