class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            adj.add(new ArrayList<>());
        }
        int min = 1;
        int max = 0;
        for(int[] e : edges)
        {
            adj.get(e[1]).add(new int[] { e[0], e[2] });
            max = Math.max(e[2], max);
        }
        int ans = -1;
        while(min <= max)
        {
            int mid = min + (max - min)/2;
            if(check(mid, adj))
            {
                ans = mid;
                max = mid-1;
            }
            else
            {
                min = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, ArrayList<ArrayList<int[]>> adj)
    {
        boolean[] vis = new boolean[adj.size()];
        dfs(0, adj, vis, guess);
        for(int i=0; i<vis.length; i++)
        {
            if(!vis[i])
            {
                return false;
            }
        }
        return true;
    }
    private void dfs(int current, ArrayList<ArrayList<int[]>> adj, boolean[] vis, int guess)
    {
        vis[current] = true;
        for(int[] next : adj.get(current))
        {
            if(vis[next[0]] || guess < next[1])
            {
                continue;
            }
            dfs(next[0], adj, vis, guess);
        }
    }
}