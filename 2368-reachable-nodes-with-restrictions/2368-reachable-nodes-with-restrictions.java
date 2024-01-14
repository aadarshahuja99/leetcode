class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int node : restricted)
        {
            set.add(node);
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges)
        {
            if(set.contains(edge[0]) || set.contains(edge[1]))
            {
                continue;
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        return dfs(0,adjList,visited);
    }
    private int dfs(int current, ArrayList<ArrayList<Integer>> adjList, int[] visited)
    {
        visited[current] = 1;
        int count = 1;
        for(int node : adjList.get(current))
        {
            if(visited[node] == 0)
            {
                count += dfs(node,adjList,visited);
            }
        }
        return count;
    }
}