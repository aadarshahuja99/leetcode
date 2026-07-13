class Solution {
    public int stoneGameII(int[] piles) {
        // Cache needs to store results. Since 0 is a valid result, 
        // we should initialize it to -1 to differentiate unvisited states.
        int[][][] cache = new int[piles.length][2][piles.length + 1];
        for (int i = 0; i < piles.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        return getAns(0, 1, 1, piles, cache);
    }

    private int getAns(int current, int isAlice, int M, int[] piles, int[][][] cache) {
        int n = piles.length;
        if (current == n) {
            return 0;
        }
        
        // 1. Check cache before computing
        if (cache[current][isAlice][M] != -1) {
            return cache[current][isAlice][M];
        }

        int ans = (isAlice == 1) ? 0 : Integer.MAX_VALUE;
        int sum = 0;

        // 2. Corrected upper limit: current + 2 * M
        for (int i = current; i < Math.min(n, current + 2 * M); i++) {
            int diff = i - current + 1;
            
            // Only Alice accumulates the score into her answer
            if (isAlice == 1) {
                sum += piles[i];
                int nextM = Math.min(n, Math.max(diff, M));
                ans = Math.max(ans, sum + getAns(i + 1, 0, nextM, piles, cache));
            } else {
                // Bob minimizes Alice's total score
                int nextM = Math.min(n, Math.max(diff, M));
                ans = Math.min(ans, getAns(i + 1, 1, nextM, piles, cache));
            }
        }

        // 3. Save to cache before returning
        cache[current][isAlice][M] = ans;
        return ans;
    }
}
