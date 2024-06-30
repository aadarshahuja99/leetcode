class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet alice = new DisjointSet(n);
        DisjointSet bob = new DisjointSet(n);
        int ans = 0;
        for(int[] edge : edges)
        {
            if(edge[0] == 3)
            {
                if(alice.union(edge[1], edge[2]) || bob.union(edge[1], edge[2]))
                {
                    ans++;
                }
            }
        }
        for(int[] edge : edges)
        {
            if(edge[0] == 1)
            {
                if(alice.union(edge[1], edge[2]))
                {
                    ans++;
                }
            }
            if(edge[0] == 2)
            {
                if(bob.union(edge[1], edge[2]))
                {
                    ans++;
                }
            }
        }
        if(alice.numberOfComponents() != 2 || bob.numberOfComponents() != 2)
        {
            return -1;
        }
        return ans;
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        int components;
        public DisjointSet(int n)
        {
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=0; i<=n; i++)
            {
                parent[i] = i;
            }
            components = n+1;
            Arrays.fill(size, 1);
        }
        private int findParent(int u)
        {
            return parent[u] = (u == parent[u] ? u : findParent(parent[u]));
        }
        public boolean union(int u, int v)
        {
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent)
            {
                return true;
            }
            if(size[uParent] >= size[vParent])
            {
                parent[vParent] = uParent;
                size[uParent] += size[vParent];
            }
            else
            {
                parent[uParent] = vParent;
                size[vParent] += size[uParent];
            }
            components--;
            return false;
        }
        public int numberOfComponents()
        {
            return components;
        }
    }
}