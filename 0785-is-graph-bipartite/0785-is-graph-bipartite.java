class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++)
        {
            if(!vis[i] && !checkForBipartitionUsingBFS(i, graph, vis))
            {
                return false;
            }
        }
        return true;
    }
    private boolean checkForBipartitionUsingBFS(int node, int[][] graph, boolean[] vis)
    {
        Queue<Integer> bfsQueue = new LinkedList<>();
        bfsQueue.add(node);
        vis[node] = true;
        int n = graph.length;
        int[] color = new int[n];
        color[node] = 1;
        while(bfsQueue.size() > 0)
        {
            int top = bfsQueue.poll();
            for(int next : graph[top])
            {
                if(vis[next] && color[next] == color[top])
                {
                    return false;
                }
                else if(!vis[next])
                {
                    vis[next] = true;
                    color[next] = color[top] == 1 ? 2 : 1;
                    bfsQueue.add(next);
                }
            }
        }
        return true;
    }
}