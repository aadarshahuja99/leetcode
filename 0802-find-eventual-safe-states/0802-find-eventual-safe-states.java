class Solution {
    List<Integer> ans;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ans = new ArrayList<>();
        int n = graph.length;
        int[] indegree = new int[n];
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        int idx = 0;
        // reverse the graph edge storage
        // Intuition: Every node that only has an incoming edge from a cycle will never be visited in Kahn's algo
        // This is because every node in the cycle will never be visited itself
        // Since the question mentions safe nodes must not have any outgoing edges to a cycle
        // We can reverse the direction of edges: Cycles will stay unaffected and the nodes which are not visited are not safe
        for(int[] edges : graph)
        {
            for(int vertex : edges)
            {
                indegree[idx]++;
                adj.get(vertex).add(idx);
            }
            idx++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        while(q.size() > 0)
        {
            int top = q.poll();
            ans.add(top);
            for(int node : adj.get(top))
            {
                indegree[node]--;
                if(indegree[node] == 0)
                {
                    q.add(node);
                }
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