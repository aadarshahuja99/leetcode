class Solution {
    int redundantEdges = 0;
    public int makeConnected(int n, int[][] connections) {
        if(n<=2)
        {
            return 0;
        }
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] connection : connections)
        {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }
        int components = 0;
        int last = -1;
        int[] visited = new int[n];
        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
            {
                components++;
                dfs(i,adjList,visited,last);
            }
        }
        // System.out.println(components + " " + (redundantEdges/2));
        if(components-1 > (redundantEdges/2))
        {
            return -1;
        }
        return components-1;
    }
    private void dfs(int current, ArrayList<ArrayList<Integer>> adjList, int[] visited, int parent)
    {
        visited[current] = 1;
        for(int node : adjList.get(current))
        {
            // System.out.println("current: " + current + ", " + node + " " + visited[node]);
            if (visited[node] == 0)
            {
                dfs(node,adjList,visited,current);
            }
            else if (node != parent)
            {
                redundantEdges += 1;
            }
        }
    }
}