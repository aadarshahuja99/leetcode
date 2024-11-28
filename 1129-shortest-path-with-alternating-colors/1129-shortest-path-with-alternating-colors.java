class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e : redEdges)
        {
            adj.get(e[0]).add(new int[] { e[1], 1 });
        }
        for(int[] e : blueEdges)
        {
            adj.get(e[0]).add(new int[] { e[1], 2 });
        }
        boolean[][] vis = new boolean[n][3];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 0 });
        while(q.size() > 0)
        {
            int[] top = q.poll();
            int current = top[0];
            int cost = top[2];
            int inc = top[1];
            if(vis[current][inc])
            {
                continue;
            }
            vis[current][inc] = true;
            distance[current] = Math.min(cost, distance[current]);
            for(int[] node : adj.get(current))
            {
                int next = node[0];
                int col = node[1];
                if(vis[next][col] || col == inc)
                {
                    continue;
                }
                q.add(new int[] { next, col, cost + 1 });
            }
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++)
        {
            ans[i] = distance[i] == Integer.MAX_VALUE ? -1 : distance[i];
        }
        return ans;
    }
}