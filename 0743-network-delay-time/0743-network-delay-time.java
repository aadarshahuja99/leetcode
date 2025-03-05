class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int visCount = 0;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times)
        {
            adj.get(edge[0]-1).add(new int[] { edge[1]-1, edge[2] });
        }
        boolean[] vis = new boolean[n];
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });
        distances[k-1] = 0;
        pq.add(new int[] { k-1, 0 });
        int maxDistance = 0;
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            int current = top[0];
            int dist = top[1];
            // System.out.println("removed "+top[0]+", "+top[1]+" from pq");
            if(vis[current])
            {
                continue;
            }
            maxDistance = Math.max(maxDistance, dist);
            vis[current] = true;
            visCount++;
            for(int[] node : adj.get(current))
            {
                if(vis[node[0]])
                {
                    continue;
                }
                if(dist + node[1] < distances[node[0]])
                {
                    // System.out.println("pushing "+(dist + node[1])+" to pq for node "+node[0]);
                    distances[node[0]] = dist + node[1];
                    pq.add(new int[] { node[0], distances[node[0]] });
                }
            }
        }
        if(visCount < n)
        {
            return -1;
        }
        return maxDistance;
    }
}