class Solution {
    private static final int INF = 1_000_000_000;

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        
        // 1. Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int time = edge[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // 2. Memoization table: memo[u][timeSpent]
        Integer[][] memo = new Integer[n][maxTime + 1];
        
        // FIX: Include passingFees[0] for the starting node, then add the cost of the rest of the path
        int result = passingFees[0] + dfs(0, 0, maxTime, n, graph, passingFees, memo);
        
        return result >= INF ? -1 : result;
    }
    
    private int dfs(int u, int timeSpent, int maxTime, int n, List<List<int[]>> graph, int[] passingFees, Integer[][] memo) {
        // Base case 1: Exceeded time limit
        if (timeSpent > maxTime) {
            return INF;
        }
        
        // Base case 2: Reached destination (n-1)
        if (u == n - 1) {
            return 0; // No further cost needed from destination
        }
        
        // Return cached result
        if (memo[u][timeSpent] != null) {
            return memo[u][timeSpent];
        }
        
        int minCostToDest = INF;
        
        // Explore all adjacent roads
        for (int[] neighbor : graph.get(u)) {
            int v = neighbor[0];
            int travelTime = neighbor[1];
            
            if (timeSpent + travelTime <= maxTime) {
                int cost = passingFees[v] + dfs(v, timeSpent + travelTime, maxTime, n, graph, passingFees, memo);
                minCostToDest = Math.min(minCostToDest, cost);
            }
        }
        
        return memo[u][timeSpent] = minCostToDest;
    }
}