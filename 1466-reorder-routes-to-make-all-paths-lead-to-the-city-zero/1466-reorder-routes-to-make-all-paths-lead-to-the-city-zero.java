class Solution {
    int ans = 0;
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : connections)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(-edge[0]);
        }
        int[] visited = new int[n];
        dfs(0,adjList,visited);
        return ans;
    }
    private void dfs(int current, ArrayList<ArrayList<Integer>> adjList, int[] visited)
    {
        visited[current] = 1;
        for(int node : adjList.get(current))
        {
            if(visited[Math.abs(node)] == 0)
            {
                if(node > 0)
                {
                    ans++;
                }
                dfs(Math.abs(node),adjList,visited);
            }
        }
    }
}