class Solution {
    private int[] time;
    private int[] low;
    private int[] parent;
    int visitedId = 0;
    private ArrayList<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ans = new ArrayList<>();
        time = new int[n];
        low = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i=0; i<n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections)
        {
            adjList.get(edge.get(0)).add(edge.get(1));
            adjList.get(edge.get(1)).add(edge.get(0));
        }
        int[] visited = new int[n];
        dfs(0,-1,visited,adjList);
        return ans;
    }
    private void dfs(int current, int par, int[] visited, ArrayList<ArrayList<Integer>> adjList)
    {
        visited[current] = 1;
        visitedId++;
        parent[current] = par;
        time[current] = visitedId;
        low[current] = visitedId;
        for(int node : adjList.get(current))
        {
            if(visited[node] == 0)
            {
                dfs(node,current,visited,adjList);
                // System.out.println("for current: "+current+" node: "+node+" => "+time[current]+" "+low[node]);
                if(low[current] > low[node])
                {
                    low[current] = low[node];
                }
                if(time[current] < low[node])
                {
                    ArrayList<Integer> edge = new ArrayList<>();
                    edge.add(current);
                    edge.add(node);
                    ans.add(edge);
                }
            }
            else if(node != par)
            {
                if(low[node] < low[current])
                {
                    low[current] = low[node];
                }
            }
        }
    }
}