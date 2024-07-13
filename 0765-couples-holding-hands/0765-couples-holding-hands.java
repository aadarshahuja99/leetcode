class Solution {
    public int minSwapsCouples(int[] row) {
        DisjointSet ds = new DisjointSet(row.length);
        for(int i=0; i<row.length; i+=2)
        {
            ds.union(row[i], row[i+1]);
        }
        int ans = 0;
        for(int i=0; i<row.length; i+=2)
        {
            if(ds.find(i) != ds.find(i+1))
            {
                ans++;
                ds.union(i, i+1);
            }
        }
        return ans;
    }
    class DisjointSet
    {
        int[] p;
        int[] s;
        public DisjointSet(int n)
        {
            p = new int[n];
            s = new int[n];
            for(int i=0; i<n; i++)
            {
                p[i] = i;
            }
            Arrays.fill(s, 1);
        }
        public int find(int u)
        {
            return p[u] = p[u] == u ? u : find(p[u]);
        }
        public void union(int u, int v)
        {
            int up = find(u);
            int vp = find(v);
            if(up == vp)
            {
                return;
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
        }
    }
}