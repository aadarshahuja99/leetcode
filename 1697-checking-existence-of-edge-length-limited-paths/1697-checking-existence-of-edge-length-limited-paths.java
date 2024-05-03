class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a,b) -> {
            return a[2] - b[2];
        });

        int numberOfQueries = queries.length;
        int[][] updatedQueries = new int[numberOfQueries][4];

        for(int i=0; i<numberOfQueries; i++)
        {
            updatedQueries[i] = new int[] { queries[i][0], queries[i][1], queries[i][2], i  };
        }

        Arrays.sort(updatedQueries, (a,b) -> {
            return a[2] - b[2];
        });

        int numberOfEdges = edgeList.length;
        int currentEdgeIndex = 0;

        boolean[] ans = new boolean[numberOfQueries];
        DisjointSet ds = new DisjointSet(n);

        for(int[] query : updatedQueries)
        {
            int distance = query[2];
            while(currentEdgeIndex < numberOfEdges && edgeList[currentEdgeIndex][2] < distance)
            {
                int u = edgeList[currentEdgeIndex][0];
                int v = edgeList[currentEdgeIndex][1];
                ds.union(u,v);
                currentEdgeIndex++;
            }
            ans[query[3]] = ds.findParent(query[0]) == ds.findParent(query[1]);
        }

        return ans;
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
            return parent[u] = (parent[u] == u ? u : findParent(parent[u]));
        }

        public void union(int u, int v)
        {
            int uParent = findParent(u);
            int vParent = findParent(v);

            if(uParent == vParent)
            {
                return;
            }

            if(size[uParent] >= size[vParent])
            {
                size[uParent] += size[vParent];
                parent[vParent] = uParent;
            }
            else
            {
                size[vParent] += size[uParent];
                parent[uParent] = vParent;
            }
        }
    }
}