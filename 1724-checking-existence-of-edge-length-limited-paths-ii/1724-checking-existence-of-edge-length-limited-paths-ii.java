class DistanceLimitedPathsExist {
    // snapshot array + uf
    TreeMap<Integer,int[]> map;
    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        map = new TreeMap<>();
        int[] parent = new int[n];
        for(int i=0; i<n; i++)
        {
            parent[i] = i;
        }
        Arrays.sort(edgeList, (a,b) -> {
            return a[2] - b[2];
        });
        int idx = 0;
        int edges = edgeList.length;
        while(idx < edges)
        {
            int j=idx;
            int val = edgeList[idx][2];
            union(edgeList[idx][0], edgeList[idx][1], parent);
            if(j < edges && edgeList[j][2] == edgeList[idx][2])
            {
                union(edgeList[j][0], edgeList[idx][0], parent);
                union(edgeList[j][0], edgeList[j][1], parent);
                j++;
            }
            map.put(val, parent.clone());
            idx = j;
        }
    }
    
    public boolean query(int p, int q, int limit) {
        var floor = map.lowerEntry(limit);
        if(floor == null)
        {
            return false;
        }
        int[] par = floor.getValue();
        return find(p, par) == find(q, par);
    }

    private void union(int u, int v, int[] parent)
    {
        int uParent = find(u, parent);
        int vParent = find(v, parent);
        if(uParent == vParent)
        {
            return;
        }
        parent[uParent] = vParent;
    }

    private int find(int u, int[] parent)
    {
        return parent[u] = (parent[u] == u ? u : find(parent[u], parent));
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */