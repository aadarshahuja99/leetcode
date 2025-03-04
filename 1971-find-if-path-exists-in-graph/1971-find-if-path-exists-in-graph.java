class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        ArrayList<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return dfs(source, adjList, new boolean[n], dest);
    }
    private boolean dfs(int current, ArrayList<List<Integer>> adjList, boolean[] vis, int dest)
    {
        vis[current] = true;
        if(current == dest)
        {
            return true;
        }
        for(int node : adjList.get(current))
        {
            if(vis[node] == false)
            {
                var status = dfs(node, adjList, vis, dest);
                if(status)
                {
                    return true;
                }
            }
        }
        return false;
    }
}