class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        distances[s] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> {
            return a[1] - b[1];
        });
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> edge : edges)
        {
            adjList.get(edge.get(0)).add(new int[] { edge.get(1), edge.get(2) });
        }
        HashSet<Integer> targets = new HashSet<>();
        for(int m : marked)
        {
            targets.add(m);
        }
        pq.add(new int[] { s, 0 });
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            if(visited[top[0]])
            {
                continue;
            }
            visited[top[0]] = true;
            if(targets.contains(top[0]))
            {
                return top[1];
            }
            
            for(int[] node : adjList.get(top[0]))
            {
                int neighbor = node[0];
                if(visited[neighbor] || top[1] + node[1] >= distances[neighbor])
                {
                    continue;
                }
                distances[neighbor] = top[1] + node[1];
                pq.add(new int[] { neighbor, distances[neighbor] });
            }
        }
        return -1;
    }
}