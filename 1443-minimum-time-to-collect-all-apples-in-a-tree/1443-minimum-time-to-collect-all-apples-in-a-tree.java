class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges)
        {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return getAns(0, new boolean[n], hasApple, adj);
    }
    private int getAns(int current, boolean[] vis, List<Boolean> hasApple, ArrayList<ArrayList<Integer>> adj)
    {
        vis[current] = true;
        int ans = 0;
        for(int node : adj.get(current))
        {
            if(vis[node])
            {
                continue;
            }
            int subTreeTotal = getAns(node, vis, hasApple, adj);
            ans += subTreeTotal;
            if(hasApple.get(node) || subTreeTotal > 0)
            {
                ans += 2;
            }
        }
        return ans;
    }
}