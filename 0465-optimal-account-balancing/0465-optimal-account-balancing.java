class Solution {
    public int minTransfers(int[][] transactions) {
        // 1. Calculate Net Balances
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        // 2. Filter non-zero debts into a list
        List<Integer> debt = new ArrayList<>();
        for (int val : map.values()) {
            if (val != 0) debt.add(val);
        }
        
        int n = debt.size();
        if (n == 0) return 0;
        
        // 3. Precompute sums for all 2^N masks
        int limit = 1 << n;
        int[] sums = new int[limit];
        
        for (int mask = 1; mask < limit; mask++) {
            for (int i = 0; i < n; i++) {
                // If the i-th bit is set, add that person's debt
                if ((mask & (1 << i)) != 0) {
                    sums[mask] = sums[mask ^ (1 << i)] + debt.get(i);
                    break; // Optimization: we calculated sum using the previous submask
                }
            }
        }

        // 4. DP: Find max number of zero-sum subsets
        int[] dp = new int[limit];
        for (int mask = 1; mask < limit; mask++) {
            // If the current subset doesn't sum to 0, it can't be partitioned into valid zero-sum groups
            // But wait: disjoint unions might sum to 0. 
            // Actually, we only care if the mask *can* be partitioned.
            if (sums[mask] == 0) {
                dp[mask] = 1; // Base case: the whole set is one zero-sum group
                // Try to break this mask into two smaller independent zero-sum masks
                // Iterate submasks: (i - 1) & mask efficiently iterates subsets
                for (int sub = (mask - 1) & mask; sub > 0; sub = (sub - 1) & mask) {
                    dp[mask] = Math.max(dp[mask], dp[sub] + dp[mask ^ sub]);
                }
            }
        }

        // Answer is Total People - Max Independent Groups
        return n - dp[limit - 1];
    }
}
