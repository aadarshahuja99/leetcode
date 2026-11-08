class Solution {
    public int makeConnected(int n, int[][] connections) {
        // intuition: find the number of extra edges during union of two nodes and also compute number of components. Number of components - 1 is the answer if extra edges >= number of Components - 1
        DS ds = new DS(n);
        int extraEdges = 0;
        for(int[] edge : connections)
        {
            if(ds.union(edge[0], edge[1]))
            {
                extraEdges++;
            }
        }
        int components = ds.getNumberOfComponents();
        return components - 1 > extraEdges ? -1 : components - 1;
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
                s[i] = 1;
                p[i] = i;
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
        public boolean union(int u, int v)
        {
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp)
            {
                return true;
            }
            if(s[up] >= s[vp])
            {
                s[up] += s[vp];
                p[vp] = up;
            }
            else
            {
                s[vp] += s[up];
                p[up] = vp;
            }
            return false;
        }
        public int getNumberOfComponents()
        {
            int count = 0;
            for(int i=0; i<p.length; i++)
            {
                int parent = findParent(i);
                if(parent == i)
                {
                    count++;
                }
            }
            return count;
        }
    }
}