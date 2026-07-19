class Solution {
    public int minScore(int n, int[][] roads) {
        // can be done using bfs/dfs more intuitively. Can also be done using Union Find
        DS ds = new DS(n+1);
        int ans = 0;
        for(int[] road : roads)
        {
            ds.union(road[0], road[1]);
            ans = Math.max(road[2], ans);
        }
        for(int[] road : roads)
        {
            if(ds.findParent(road[0]) == ds.findParent(n))
            {
                ans = Math.min(ans, road[2]);
            }
        }
        return ans;
    }
    class DS
    {
        int[] p;
        int[] s;
        DS(int n)
        {
            p = new int[n];
            s = new int[n];
            for(int i=0; i<n; i++)
            {
                p[i] = i;
                s[i] = 1;
            }
        }
        public int findParent(int u)
        {
            if(p[u] == u)
            {
                return u;
            }
            return p[u] = findParent(p[u]);
        }
        public void union(int u, int v)
        {
            int pU = findParent(u);
            int pV = findParent(v);
            if(pU == pV)
            {
                return;
            }
            if(s[pU] >= s[pV])
            {
                p[pV] = pU;
                s[pU] += s[pV];
            }
            else
            {
                p[pU] = pV;
                s[pV] += s[pU];
            }
        }
    }
}