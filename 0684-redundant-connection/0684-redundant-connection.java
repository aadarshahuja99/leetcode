class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length);
        for(int[] edge : edges)
        {
            if(!ds.union(edge[0]-1,edge[1]-1))
            {
                return edge;
            }
        }
        return new int[2];
    }
    class DisjointSet
    {
        int[] size;
        int[] parent;
        public DisjointSet(int n)
        {
            size = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
            Arrays.fill(size, 1);
        }
        public int findParent(int u)
        {
            return parent[u] == u ? u : findParent(parent[u]);
        }
        public boolean union(int u, int v)
        {
            int uPar = findParent(u);
            int vPar = findParent(v);
            if(uPar == vPar)
            {
                return false;
            }
            if(size[uPar] < size[vPar])
            {
                parent[uPar] = vPar;
                size[vPar] += size[uPar];
            }
            else
            {
                parent[vPar] = uPar;
                size[uPar] += size[vPar];
            }
            return true;
        }
    }
}