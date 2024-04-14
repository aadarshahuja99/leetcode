class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = vals.length;
        TreeMap<Integer,ArrayList<Integer>> valueMap = new TreeMap<>();
        for(int i=0; i<n; i++)
        {
            int val = vals[i];
            adjList.add(new ArrayList<>());
            if(!valueMap.containsKey(val))
            {
                valueMap.put(val, new ArrayList<>());
            }
            valueMap.get(val).add(i);
        }
        for(int[] edge : edges)
        {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        DisjointSet ds = new DisjointSet(n);
        int numberOfGoodPaths = 0;
        for(int value : valueMap.keySet())
        {
            ArrayList<Integer> nodes = valueMap.get(value);
            numberOfGoodPaths += nodes.size();
            for(int node : nodes)
            {
                for(int neighbor : adjList.get(node))
                {
                    if(vals[neighbor] <= value)
                    {
                        ds.union(node, neighbor);
                    }
                }
            }

            HashMap<Integer, Integer> nodeGroupsByComponent = new HashMap<>();
            for(int node : nodes)
            {
                int ultimateParent = ds.findParent(node);
                if(!nodeGroupsByComponent.containsKey(ultimateParent))
                {
                    nodeGroupsByComponent.put(ultimateParent, 0);
                }
                nodeGroupsByComponent.put(ultimateParent, nodeGroupsByComponent.get(ultimateParent)+1);
            }
            for(Map.Entry<Integer,Integer> entry : nodeGroupsByComponent.entrySet())
            {
                int numberOfNodesForCurrentParent = entry.getValue();
                // System.out.println(numberOfNodesForCurrentParent+" for "+value);
                numberOfGoodPaths += (numberOfNodesForCurrentParent)*(numberOfNodesForCurrentParent-1)/2;
            }
        }
        return numberOfGoodPaths;
    }
    class DisjointSet
    {
        private int[] _parent;
        private int[] _size;
        public DisjointSet(int n)
        {
            _parent = new int[n];
            _size = new int[n];
            Arrays.fill(_size, 1);
            for(int i=0; i<n; i++)
            {
                _parent[i] = i;
            }
        }
        public int findParent(int u)
        {
            return _parent[u] = (_parent[u] == u ? u : findParent(_parent[u]));
        }
        public void union(int u, int v)
        {
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent)
            {
                return;
            }
            if(_size[uParent] >= _size[vParent])
            {
                _parent[vParent] = uParent;
                _size[uParent] += _size[vParent];
            }
            else
            {
                _parent[uParent] = vParent;
                _size[vParent] += _size[uParent];
            }
        }
    }
}