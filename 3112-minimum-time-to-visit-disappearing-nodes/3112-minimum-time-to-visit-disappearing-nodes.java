class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<int[]>());
        }
        for(int[] edge : edges)
        {
            if(edge[0] == edge[1])
            {
                continue;
            }
            adjList.get(edge[0]).add(new int[] { edge[1], edge[2] });
            adjList.get(edge[1]).add(new int[] { edge[0], edge[2] });
        }
        int[] minimumDistances = new int[n];
        Arrays.fill(minimumDistances,Integer.MAX_VALUE);
        minimumDistances[0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a,b) -> {
            return a[0] - b[0];
        });
        boolean[] visited = new boolean[n];
        // 0th idx: distance, 1st idx: node
        minHeap.add(new int[] { 0, 0 });
        while(minHeap.size() > 0)
        {
            var top = minHeap.poll();
            int currentNode = top[1];
            int distance = top[0];
            if(visited[currentNode])
            {
                continue;
            }
            visited[currentNode] = true;
            for(int[] neighbor : adjList.get(currentNode))
            {
                int nextNode = neighbor[0];
                int addedDistance = neighbor[1];
                int nextCost = addedDistance + distance;
                if(nextCost < minimumDistances[nextNode] && nextCost < disappear[nextNode] && !visited[nextNode])
                {
                    minimumDistances[nextNode] = nextCost;
                    minHeap.add(new int[] { nextCost, nextNode });
                }
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        for(int distance : minimumDistances)
        {
            ans[idx] = distance == Integer.MAX_VALUE ? -1 : distance;
            idx++;
        }
        return ans;
    }
}