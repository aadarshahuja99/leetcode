class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<int[]>());
        }
        for(int[] flight : flights)
        {
            adjList.get(flight[0]).add(new int[] { flight[1], flight[2] });
        }
        int[][] distances = new int[n][k+1];
        for(int[] row : distances)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        distances[src][k] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        // distance, node, k
        queue.add(new int[] { 0, src, k });
        while(queue.size() > 0)
        {
            int[] top = queue.poll();
            int currentNode = top[1];
            int distance = top[0];
            int remainingStops = top[2];
            // System.out.println(remainingStops+" "+distance+" "+currentNode);
            // || visited[currentNode][remainingStops] == 1
            if(remainingStops < 0 )
            {
                continue;
            }
            // visited[currentNode][remainingStops] = 1;
            for(int[] node : adjList.get(currentNode))
            {
                int distanceToChild = distance + node[1];
                if(distanceToChild < distances[node[0]][remainingStops])
                {
                    distances[node[0]][remainingStops] = distanceToChild;
                    queue.add(new int[] { distanceToChild, node[0], remainingStops-1 });
                }
            }
        }
        int minDistance = Integer.MAX_VALUE;
        for(int i=0; i<=k ;i++)
        {
            minDistance = Math.min(minDistance, distances[dst][i]);
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}