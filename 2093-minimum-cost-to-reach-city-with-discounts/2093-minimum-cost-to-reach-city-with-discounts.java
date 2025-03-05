class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        // Dijktra's algorithm
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<int[]>());
        }
        for(int[] highway : highways)
        {
            adjList.get(highway[0]).add(new int[] { highway[1], highway[2] });
            adjList.get(highway[1]).add(new int[] { highway[0], highway[2] });
        }
        int[][] distances = new int[n][discounts+1];
        for(int[] row : distances)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for(int i=0; i<=discounts; i++)
        {
            distances[0][i] = 0;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });
        minHeap.add(new int[] { 0, 0, discounts });
        while(minHeap.size() > 0)
        {
            var top = minHeap.poll();
            int cost = top[1];
            int node = top[0];
            int discountsAvailable = top[2];
            if(node == n-1)
            {
                return cost;
            }
            for(int[] child : adjList.get(node))
            {
                if(distances[child[0]][discountsAvailable] > cost + child[1])
                {
                    // System.out.println("pushing "+child[0]+" "+(cost + child[1])+" to the queue.");
                    distances[child[0]][discountsAvailable] = cost + child[1];
                    minHeap.add(new int[] { child[0], distances[child[0]][discountsAvailable], discountsAvailable });
                }
                if(discountsAvailable > 0 && (distances[child[0]][discountsAvailable - 1] > cost + child[1]/2))
                {
                    // System.out.println("pushing "+child[0]+" "+(cost + child[1]/2)+" to the queue.");
                    distances[child[0]][discountsAvailable-1] = cost + child[1]/2;
                    minHeap.add(new int[] { child[0], distances[child[0]][discountsAvailable - 1], discountsAvailable - 1 });
                }
            }
        }
        return -1;
    }
}