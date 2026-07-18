class Solution {
    List<Integer> ans;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ans = new ArrayList<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(!vis[i])
            {
                dfs(i, vis, pathVis, graph);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    private boolean dfs(int current, boolean[] vis, boolean[] pathVis, int[][] graph)
    {
        int n = graph.length;
        vis[current] = true;
        pathVis[current] = true;
        for(int node : graph[current])
        {
            if(!vis[node])
            {
                boolean status = dfs(node, vis, pathVis, graph);
                if(!status)
                {
                    // the outgoing path from current to node is a part of a cycle
                    return false;
                }
            }
            else if(pathVis[node])
            {
                // the outgoing path from current to node is a part of a cycle
                return false;
            }
        }
        // if the control reaches here, then it means that every outgoing path from the current node, does not contain a cycle and ends somewhere
        pathVis[current] = false;
        ans.add(current);
        return true;
    }
}