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
        int[] distances = new int[n];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[src] = 0;
        Queue<int[]> queue = new LinkedList<>();
        // node, distance, k
        queue.add(new int[] { src, 0, k });
        while(queue.size() > 0)
        {
            var top = queue.poll();
            int node = top[0];
            int distance = top[1];
            int stops = top[2];
            if(stops < 0)
            {
                break;
            }
            for(int[] neighbor : adjList.get(node))
            {
                int newDistance = neighbor[1] + distance;
                if(newDistance < distances[neighbor[0]])
                {
                    distances[neighbor[0]] = newDistance;
                    queue.add(new int[] { neighbor[0], newDistance, stops-1 });
                }
            }
        }
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}