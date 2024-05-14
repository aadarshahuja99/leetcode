class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int breakingEdge1 = -1;
        int breakingEdge2 = -1;
        int[] parentEdge = new int[n+1];
        Arrays.fill(parentEdge, -1);
        for(int i=0; i<n; i++)
        {
            int target = edges[i][1];
            if(parentEdge[target] == -1)
            {
                parentEdge[target] = i;
            }
            else
            {
                breakingEdge1 = i;
                breakingEdge2 = parentEdge[target];
                break;
            }
        }
        // System.out.println(breakingEdge1+" "+breakingEdge2);
        DisjointSet ds = new DisjointSet(n);
        for(int i=0; i<n; i++)
        {
            if(i == breakingEdge1)
            {
                continue;
            }
            if(ds.union(edges[i][0], edges[i][1]))
            {
                // if no double parent exists, breakingEdges1 and 2 are -1, return the current edge as it lead to a cycle in graph
                if(breakingEdge1 == -1)
                {
                    return edges[i];
                }
                else
                {
                    return edges[breakingEdge2];
                }
            }
        }
        return edges[breakingEdge1];
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        public DisjointSet(int n)
        {
            parent = new int[n+1];
            size = new int[n+1];
            for(int i=0; i<=n; i++)
            {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int findParent(int u)
        {
            return parent[u] = (parent[u] == u ? u : findParent(parent[u]));
        }
        public boolean union(int from, int to)
        {
            int fromParent = findParent(from);
            int toParent = findParent(to);
            if(fromParent == toParent)
            {
                return true;
            }
            if(size[fromParent] >= size[toParent])
            {
                size[fromParent] += size[toParent];
                parent[toParent] = fromParent;
            }
            else
            {
                size[toParent] += size[fromParent];
                parent[fromParent] = toParent;
            }
            return false;
        }
    }
}