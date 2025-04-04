class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0 && pathVisited[i] == 0)
            {
                dfs(i,edges,visited,pathVisited);
            }
        }
        return ans;
    }
    private Pair<Integer,Integer> dfs(int current, int[] edges, int[] visited, int[] pathVisited)
    {
        visited[current] = 1;
        pathVisited[current] = 1;
        if(edges[current] != -1 && visited[edges[current]] == 0)
        {
            var status = dfs(edges[current], edges, visited, pathVisited);
            if(status.getKey() != -1)
            {
                int dist = status.getValue();
                if(status.getKey() == current)
                {
                    // update the ans and return -1 as source to the parent
                    ans = Math.max(ans, dist+1);
                    return new Pair<>(-1,0);
                }
                return new Pair<>(status.getKey(), dist+1);
            }
        }
        else if(edges[current] != -1 && pathVisited[edges[current]] == 1)
        {
            return new Pair<>(edges[current], 1);
        }
        pathVisited[current] = 0;
        return new Pair<>(-1,0);
    }
}