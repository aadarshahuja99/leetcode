class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n+1; i++)
        {
            adjList.add(new ArrayList<>());
        }
        // adding the edges from the single well node to all other houses
        for(int i=0; i<n; i++)
        {
            adjList.get(0).add(new int[] { i+1, wells[i] });
            adjList.get(i+1).add(new int[] { 0, wells[i] });
        }
        for(int[] pipe : pipes)
        {
            adjList.get(pipe[0]).add(new int[] { pipe[1], pipe[2] });
            adjList.get(pipe[1]).add(new int[] { pipe[0], pipe[2] });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return a[1] - b[1];
        });
        boolean[] visited = new boolean[n+1];
        int cost = 0;

        minHeap.add(new int[] { 0, 0 });
    
        while(minHeap.size() > 0)
        {
            var top = minHeap.poll();
            int currentNode = top[0];
            if(visited[currentNode])
            {
                continue;
            }
            visited[currentNode] = true;
            int currentCost = top[1];
            cost += currentCost;
            for(int[] node : adjList.get(currentNode))
            {
                if(!visited[node[0]])
                {
                    minHeap.add(new int[] { node[0], node[1] });
                }
            }
        }

        return cost;
    }
}