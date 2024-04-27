class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a,b) -> {
            return a[0] - b[0];
        });
        int lastTimeStamp = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int[] log : logs)
        {
            if(ds.union(log[1], log[2]))
            {
                lastTimeStamp = log[0];
            }
        }
        HashSet<Integer> parents = new HashSet<>();
        for(int i=0; i<n; i++)
        {
            parents.add(ds.findParent(i));
            if(parents.size() > 1)
            {
                return -1;
            }
        }
        return lastTimeStamp;
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        public DisjointSet(int n)
        {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }

        public int findParent(int u)
        {
            return parent[u] = (u == parent[u] ? u : findParent(parent[u]));
        }

        public boolean union(int u, int v)
        {
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent)
            {
                return false;
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
            return true;
        }
    }
}