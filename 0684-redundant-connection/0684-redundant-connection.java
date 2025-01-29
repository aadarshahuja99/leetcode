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
        int[] rank;
        int[] parent;
        public DisjointSet(int n)
        {
            rank = new int[n];
            parent = new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
        }
        public int findParent(int u)
        {
            int temp = u;
            while(temp != parent[temp])
            {
                temp = parent[temp];
            }
            parent[u] = temp;
            return temp;
        }
        public boolean union(int u, int v)
        {
            int uPar = findParent(u);
            int vPar = findParent(v);
            if(uPar == vPar)
            {
                return false;
            }
            if(rank[uPar] < rank[vPar])
            {
                parent[uPar] = vPar;
                rank[vPar]+=1;
            }
            else
            {
                parent[vPar] = uPar;
                rank[uPar]+=1;
            }
            return true;
        }
    }
}