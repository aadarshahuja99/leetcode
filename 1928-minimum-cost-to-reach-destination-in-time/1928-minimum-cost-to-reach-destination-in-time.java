public class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        
        // 1. Build adjacency list: node -> List of [neighbor, travel_time]
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
        
        // 2. Track the minimum time to reach each node
        // minTime[i] stores the minimum time taken to reach node i so far
        int[][] costs = new int[n][maxTime+1];
        for(int[] row : costs)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        boolean[][] vis = new boolean[n][maxTime+1];
        for(int i=0; i<= maxTime; i++)
        {
            costs[0][i] = 0;
        }
        // 3. Min-Heap ordered by cost: [cost, node, timeSpent]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // Push starting node (0) with its passing fee, node index, and 0 time spent
        pq.offer(new int[]{passingFees[0], 0, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int u = curr[1];
            int currTime = curr[2];
            if(vis[u][currTime])
            {
                continue;
            }
            vis[u][currTime] = true;
            // Explore neighbors
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int travelTime = neighbor[1];
                int nextTime = currTime + travelTime;
                int newCost = currCost + passingFees[v];
                // Only proceed if within the allowed time limit
                if (nextTime <= maxTime && newCost < costs[v][nextTime]) {
                    // Update minTime if we found a strictly faster way to reach node v
                    pq.offer(new int[]{newCost, v, nextTime});
                    costs[v][nextTime] = newCost;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=maxTime; i++)
        {
            ans = Math.min(ans, costs[n-1][i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}