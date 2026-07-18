class Solution {
    // Sieve array to store prime status up to 100,000
    private static final int MAX = 100_000;
    private static final boolean[] isPrime = new boolean[MAX + 1];
    // Generates primes once across all test cases
    private static void generatePrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    public int minOperations(int n, int m) {
        generatePrimes();
        
        // If either n or m is a prime number, it's an invalid state
        if (isPrime[n] || isPrime[m]) {
            return -1;
        }

        // Min-PriorityQueue sorting by steps (index 0)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        HashSet<Integer> visited = new HashSet<>();

        // Elements in PQ: {steps/cost, current_number}
        pq.add(new int[]{n, n});

        HashMap<Integer,Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int steps = top[0];
            int curr = top[1];

            if (visited.contains(curr)) continue;
            visited.add(curr);

            if (curr == m) return steps;

            char[] s = String.valueOf(curr).toCharArray();
            for (int i = 0; i < s.length; i++) {
                char original = s[i];

                // Option 1: Increment digit
                if (s[i] < '9') {
                    s[i]++;
                    int next = Integer.parseInt(new String(s));
                    if (!isPrime[next] && dist.getOrDefault(next, Integer.MAX_VALUE) > steps + next) {
                        pq.add(new int[]{steps + next, next});
                        dist.put(next, steps + next);
                    }
                    s[i] = original; // Backtrack
                }

                // Option 2: Decrement digit (avoiding leading zeros)
                if (s[i] > '0' && !(i == 0 && s[i] == '1')) {
                    s[i]--;
                    int next = Integer.parseInt(new String(s));
                    if (!isPrime[next] && dist.getOrDefault(next, Integer.MAX_VALUE) > steps + next) {
                        pq.add(new int[]{steps + next, next});
                        dist.put(next, steps + next);
                    }
                    s[i] = original; // Backtrack
                }
            }
        }
        return -1;
    }
}
