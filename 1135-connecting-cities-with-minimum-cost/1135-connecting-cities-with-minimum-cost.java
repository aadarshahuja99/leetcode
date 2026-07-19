class Solution {
    public int minimumCost(int n, int[][] connections) {
        ArrayList<int[]>[] adj = new ArrayList[n];
        for(int i=0; i<n; i++)
        {
            adj[i] = new ArrayList<>();
        }
        for(int[] connection : connections)
        {
            adj[connection[0]-1].add(new int[] { connection[1]-1, connection[2] });
            adj[connection[1]-1].add(new int[] { connection[0]-1, connection[2] });
        }
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        int ans = 0;
        int visitedCount = 0;
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            int node = top[0];
            int dist = top[1];
            if(vis[node]) continue;
            vis[node] = true;
            ans += dist;
            visitedCount++;
            for(int[] neighbor : adj[node])
            {
                if(vis[neighbor[0]]) continue;
                pq.add(new int[] { neighbor[0], neighbor[1] });
            }
        }
        return visitedCount < n ? -1 : ans;
    }
}