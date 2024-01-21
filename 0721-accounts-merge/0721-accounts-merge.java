class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        DisjointSet ds = new DisjointSet(accounts.size());
        for(int i=0; i<accounts.size(); i++)
        {
            for(int j=1; j<accounts.get(i).size(); j++)
            {
                if(map.containsKey(accounts.get(i).get(j)))
                {
                    ds.union(i,map.get(accounts.get(i).get(j)));
                }
                else
                {
                    map.put(accounts.get(i).get(j),i);
                }
            }
        }
        ArrayList<LinkedList<String>> updated = new ArrayList<LinkedList<String>>();
        for(int i=0; i<accounts.size(); i++)
        {
            updated.add(new LinkedList<String>());
        }
        for(var entry : map.entrySet())
        {
            String email = entry.getKey();
            int val = entry.getValue();
            int parent = ds.findParent(val);
            updated.get(parent).addLast(email);
        }
        ArrayList<List<String>> ans = new ArrayList<List<String>>();
        for(var list : updated)
        {
            if(list.size() > 0)
            {
                Collections.sort(list);
                String element = list.getFirst();
                int parent = map.get(element);
                int ultimateParent = ds.findParent(parent);
                list.addFirst(accounts.get(ultimateParent).get(0));
                ans.add(new ArrayList<String>(list));
            }
        }
        return ans;
    }
    class DisjointSet
    {
        private int[] parent;
        private int[] size;
        public DisjointSet(int n)
        {
            parent = new int[n];
            size = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
                size[i] = 1;
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
        public void union(int u, int v)
        {
            int parU = findParent(u);
            int parV = findParent(v);
            if(parU == parV)
            {
                return;
            }
            if(size[parU] > size[parV])
            {
                parent[parV] = parU;
                size[parU] += size[parV];
            }
            else
            {
                parent[parU] = parV;
                size[parV] += size[parU];
            }
        }
    }
}