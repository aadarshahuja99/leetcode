class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a,b) -> {
            return a[2] - b[2];
        });
        DisjointSet ds = new DisjointSet(n);
        ds.union(0,firstPerson);
        int m=meetings.length;
        for(int i=0; i<m;)
        {
            int j=i;
            while(j < m && meetings[j][2] == meetings[i][2])
            {
                ds.union(meetings[j][0], meetings[j][1]);
                j++;
            }
            int par = ds.findParent(0);
            for(int k=i; k<j; k++)
            {
                if(ds.findParent(meetings[k][0]) != par)
                {
                    ds.reset(meetings[k][0], meetings[k][1]);
                }
            }
            i=j;
        }
        return ds.getAns();
    }

    class DisjointSet
    {
        int[] parent;
        int n;
        public DisjointSet(int people)
        {
            n = people;
            parent = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }
        public int findParent(int u)
        {
            if(parent[u] == u)
            {
                return u;
            }
            return (parent[u] = findParent(parent[u]));
        }
        public void union(int u, int v)
        {
            parent[findParent(u)] = findParent(v);
        }
        public void reset(int u, int v)
        {
            parent[u] = u;
            parent[v] = v;
        }
        public List<Integer> getAns()
        {
            List<Integer> ans = new ArrayList<>();
            int par = findParent(0);
            for(int i=0; i<n; i++)
            {
                if(findParent(i) == par)
                {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}