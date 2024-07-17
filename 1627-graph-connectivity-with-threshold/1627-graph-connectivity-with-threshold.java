class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        DisjointSet ds = new DisjointSet(n);
        for(int i=threshold+1; i<=n; i++)
        {
            for(int j=i; j<=n; j+=i)
            {
                ds.union(i,j);
            }
        }
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int[] query : queries)
        {
            ans.add(ds.findParent(query[0])==ds.findParent(query[1]));
        }
        return ans;
    }
    class DisjointSet
    {
        private int[] size;
        private int[] parent;
        public DisjointSet(int n)
        {
            size = new int[n+1];
            parent = new int[n+1];
            for(int i=1; i<n+1; i++)
            {
                parent[i] = i;
            }
            parent[0] = -1;
            Arrays.fill(size,1);
        }
        public void union(int u, int v)
        {
            int parU = findParent(u);
            int parV = findParent(v);
            if(parU == parV)
            {
                return;
            }
            if(size[parV] > size[parU])
            {
                parent[parV] = parU;
                size[parU] += size[parV];
            }
            else
            {
                parent[parU] = parV;
                size[parV] += size[parU];
            }
        }
        public int findParent(int node)
        {
            int temp = node;
            while(temp != parent[temp])
            {
                temp = parent[temp];
            }
            parent[node] = temp;
            return temp;
        }
    }
}