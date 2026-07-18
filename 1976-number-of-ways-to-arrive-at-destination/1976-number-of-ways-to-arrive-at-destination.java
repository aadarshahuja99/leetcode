class Solution {
    public int countPaths(int n, int[][] roads) {
        if(n==1)
        {
            return 1;
        }
        ArrayList<ArrayList<long[]>> adjList = new ArrayList<ArrayList<long[]>>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<long[]>());
        }
        for(int[] road : roads)
        {
            adjList.get(road[0]).add(new long[] { 1l*road[1],(long)road[2] });
            adjList.get(road[1]).add(new long[] { 1l*road[0],(long)road[2] });
        }
        int[] paths = new int[n];
        long[] distances = new long[n];
        Arrays.fill(distances,Long.MAX_VALUE);
        distances[0] = 0;
        paths[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> {
            return Long.compare(a[1], b[1]);
        });
        pq.add(new long[] { 0l, 0l });
        boolean[] vis = new boolean[n];
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int index = (int)top[0];
            long dist = top[1];
            if(vis[index])
            {
                continue;
            }
            vis[index] = true;
            for(long[] node : adjList.get(index))
            {
                if(distances[(int)node[0]] > dist + node[1])
                {
                    distances[(int)node[0]] = dist + node[1];
                    paths[(int)node[0]] = paths[index];
                    pq.add(new long[] { node[0], distances[(int)node[0]] });
                }
                else if(distances[(int)node[0]] == dist + node[1])
                {
                    paths[(int)node[0]] = ((paths[(int)node[0]]) + (paths[index]))%1000000007;
                }
            }
        }
        return paths[n-1];
    }
}