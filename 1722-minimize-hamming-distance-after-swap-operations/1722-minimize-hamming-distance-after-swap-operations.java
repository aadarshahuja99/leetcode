class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DisjointSet ds = new DisjointSet(n);
        for(int[] allowedSwap : allowedSwaps)
        {
            ds.union(allowedSwap[0], allowedSwap[1]);
        }
        var groups = ds.getGroups();
        int distance = n;
        int diff = 0;
        for(var group : groups)
        {
            HashMap<Integer,Integer> sourceMap = new HashMap<>();
            for(int i : group)
            {
                sourceMap.put(source[i], sourceMap.getOrDefault(source[i],0) + 1);
            }
            for(int i : group)
            {
                if(sourceMap.getOrDefault(target[i], 0) > 0)
                {
                    sourceMap.put(target[i], sourceMap.get(target[i]) - 1);
                }
                else
                {
                    // target can not be matched with any of the integers in source subsequence component
                    // we have found one pair of difference
                    diff++;
                }
            }
        }
        return diff;
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        public DisjointSet(int n)
        {
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
            Arrays.fill(size,1);
        }
        private int findParent(int u)
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
                parent[vParent] = uParent;
                size[uParent] += size[vParent];
            }
            else
            {
                parent[uParent] = vParent;
                size[vParent] += size[uParent];
            }
        }
        public ArrayList<ArrayList<Integer>> getGroups()
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            HashMap<Integer, ArrayList<Integer>> parentToChildMap = new HashMap<>();
            for(int i=0; i<parent.length; i++)
            {
                int p = findParent(i);
                if(parentToChildMap.containsKey(p))
                {
                    parentToChildMap.get(p).add(i);
                }
                else
                {
                    ArrayList<Integer> children = new ArrayList<>();
                    children.add(i);
                    parentToChildMap.put(p,children);
                }
            }
            for(Map.Entry<Integer,ArrayList<Integer>> entry : parentToChildMap.entrySet())
            {
                // System.out.println(entry.getValue().toString()+" "+entry.getKey());
                list.add(entry.getValue());
            }
            return list;
        }
    }
}