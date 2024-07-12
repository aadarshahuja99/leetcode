class Solution {
    public int[] distanceToCycle(int n, int[][] edges) {
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 1)
            {
                indegree[i] = 0;
                // System.out.println("adding "+i+" to queue");
                queue.add(i);
            }
        }

        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                int top = queue.poll();
                for(int node : adjList.get(top))
                {
                    if(indegree[node] == 0)
                    {
                        continue;
                    }
                    indegree[node]--;
                    if(indegree[node] == 1)
                    {
                        indegree[node] = 0;
                        queue.add(node);
                    }
                }
            }
        }

        boolean[] vis = new boolean[n];
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        for(int i=0; i<n; i++)
        {
            if(indegree[i] > 0)
            {
                queue.add(i);
                distances[i] = 0;
                vis[i] = true;
            }
        }

        int dist = 0;
        while(queue.size() > 0)
        {
            dist++;
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                for(int node : adjList.get(top))
                {
                    if(!vis[node])
                    {
                        // System.out.println("visiting "+node+" from "+top);
                        distances[node] = dist;
                        queue.add(node);
                        vis[node] = true;
                    }
                }
            }
        }

        return distances;
    }
}