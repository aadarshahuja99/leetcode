class Solution {
    public int minCost(int n, int[][] edges) {
        ArrayList<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n];
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adj.get(edge[1]).add(new int[] { edge[0], 2*edge[2] });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        pq.add(new int[] { 0, 0 });
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            if(vis[node])
            {
                continue;
            }
            vis[node] = true;
            for(int[] next : adj.get(node))
            {
                if(d + next[1] < distances[next[0]])
                {
                    distances[next[0]] = d + next[1];
                    pq.add(new int[] { d + next[1], next[0] });
                }
            }
        }
        return distances[n-1] == Integer.MAX_VALUE ? -1 : distances[n-1];
    }
}