class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int ans = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                ans++;
                dfs(i, adjList, visited);
            }
        }
        return ans;
    }
    private void dfs(int current, ArrayList<ArrayList<Integer>> adjList, boolean[] visited)
    {
        visited[current] = true;
        for(int node : adjList.get(current))
        {
            if(visited[node])
            {
                continue;
            }
            dfs(node, adjList, visited);
        }
    }
}