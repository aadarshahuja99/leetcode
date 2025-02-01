class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int size = 4*n*n;
        int r = 0;
        DisjointSet ds = new DisjointSet(size);
        for(String row : grid)
        {
            int c = 0;
            for(char ch : row.toCharArray())
            {
                int base = 4*n*r + 4*c;
                if(ch != '\\')
                {
                    ds.union(base, base+1);
                    ds.union(base+2, base+3);
                }
                if(ch != '/')
                {
                    ds.union(base, base+3);
                    ds.union(base+1, base+2);
                }
                if(r != n-1)
                {
                    ds.union(base+2, 4*n*(r+1) + 4*c);
                }
                if(c != n-1)
                {
                    ds.union(base+3, 4*n*r + 4*(c+1) + 1);
                }
                c++;
            }
            r++;
        }
        return ds.getNumberOfComponents();
    }
    class DisjointSet
    {
        int n;
        int[] p;
        int[] s;
        public DisjointSet(int size)
        {
            n = size;
            p = new int[n];
            s = new int[n];
            Arrays.fill(s, 1);
            for(int i=0; i<n; i++)
            {
                p[i] = i;
            }
        }
        private int find(int u)
        {
            return p[u] = p[u] == u ? u : find(p[u]);
        }
        public void union(int u, int v)
        {
            int uP = find(u);
            int uV = find(v);
            if(uP == uV)
            {
                return;
            }
            if(s[uP] >= s[uV])
            {
                p[uV] = uP;
                s[uP] += s[uV];
            }
            else
            {
                p[uP] = uV;
                s[uV] += s[uP];
            }
            n -= 1;
        }
        public int getNumberOfComponents()
        {
            return n;
        }
    }
}