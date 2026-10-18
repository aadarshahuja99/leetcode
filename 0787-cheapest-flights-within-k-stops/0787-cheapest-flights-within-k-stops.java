class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Distance array representing the minimum cost to reach each node
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Perform Bellman-Ford style relaxation K + 1 times
        // (Since k stops means at most k + 1 flights)
        for (int i = 0; i <= k; i++) {
            // Use a temporary array to prevent using updates from the same iteration
            int[] tempPrices = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int u = flight[0];
                int v = flight[1];
                int cost = flight[2];

                // If node u is reachable, try relaxing the edge to v
                if (prices[u] != Integer.MAX_VALUE) {
                    if (prices[u] + cost < tempPrices[v]) {
                        tempPrices[v] = prices[u] + cost;
                    }
                }
            }
            prices = tempPrices;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}