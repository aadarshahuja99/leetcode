class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DS ds = new DS(n);
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i == j) continue;
                if(isConnected[i][j] == 1) ds.union(i,j);
            }
        }
        int ans = 0;
        for(int i=0; i<n; i++)
        {
            if(ds.findParent(i) == i)
            {
                ans++;
            }
        }
        return ans;
    }
    class DS {
        int[] par;
        int[] size;
        DS(int n)
        {
            par = new int[n];
            size = new int[n];
            
            for(int i=0; i<n; i++)
            {
                par[i] = i;
                size[i] = 1;
            }
        }
        public int findParent(int u)
        {
            if(par[u] == u)
            {
                return u;
            }
            return par[u] = findParent(par[u]);
        }
        public void union(int u, int v)
        {
            int pU = findParent(u);
            int pV = findParent(v);
            if(pU == pV) { return; }
            if(size[pU] >= size[pV])
            {
                size[pU] += size[pV];
                par[pV] = pU;
            }
            else
            {
                size[pV] += size[pU];
                par[pU] = pV;
            }
        }
    }
}