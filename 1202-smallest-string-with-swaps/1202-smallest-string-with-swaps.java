class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // focus on the text in bold. ANY NUMBER OF TIMES.
        // This means bubble sort based swapping will also work for indices that are CONNECTED to each other
        // CONNECTED -> DSU
        int n = s.length();
        DisjointSet ds = new DisjointSet(n);
        for(List<Integer> pair : pairs)
        {
            ds.union(pair.get(0), pair.get(1));
        }
        var groups = ds.getGroups();
        char[] sortedString = new char[n];
        for(ArrayList<Integer> group : groups)
        {
            char[] chars = new char[group.size()];
            int it = 0;
            for(int idx : group)
            {
                chars[it] = s.charAt(idx);
                it++;
            }
            Arrays.sort(chars);
            it = 0;
            for(int idx : group)
            {
                sortedString[idx] = chars[it];
                it++;
            }
        }
        return new String(sortedString);
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
            ArrayList<ArrayList<Integer>> groups = new ArrayList<ArrayList<Integer>>();
            HashMap<Integer,ArrayList<Integer>> parentToChildMap = new HashMap<>();
            for(int i=0; i<parent.length; i++)
            {
                int p = findParent(i);
                // System.out.println(p+" "+i);
                if(!parentToChildMap.containsKey(p))
                {
                    ArrayList<Integer> children = new ArrayList<>();
                    children.add(i);
                    parentToChildMap.put(p,children);
                }
                else
                {
                    parentToChildMap.get(p).add(i);
                }
            }
            for(Map.Entry<Integer,ArrayList<Integer>> entry : parentToChildMap.entrySet())
            {
                groups.add(entry.getValue());
            }
            return groups;
        }
    }
}