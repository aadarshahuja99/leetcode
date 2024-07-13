class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> pairs) {
        HashMap<String,Integer> map = new HashMap<>();
        if(sentence1.length != sentence2.length)
        {
            return false;
        }
        int idx = 0;
        for(var pair : pairs)
        {
            if(!map.containsKey(pair.get(0)))
            {
                map.put(pair.get(0), idx);
                idx++;
            }
            if(!map.containsKey(pair.get(1)))
            {
                map.put(pair.get(1), idx);
                idx++;
            }
        }
        int count = idx;
        DisjointSet ds = new DisjointSet(count);
        for(var pair : pairs)
        {
            int i1 = map.get(pair.get(0));
            int i2 = map.get(pair.get(1));
            ds.union(i1, i2);
        }
        for(int i=0; i<sentence1.length; i++)
        {
            if(sentence1[i].equals(sentence2[i]))
            {
                continue;
            }
            int v1 = map.getOrDefault(sentence1[i], -1);
            int v2 = map.getOrDefault(sentence2[i], -1);
            if(v1 == -1 || v2 == -1 || ds.find(v1) != ds.find(v2))
            {
                return false;
            }
        }
        return true;
    }
    class DisjointSet
    {
        int[] par;
        int[] size;
        public DisjointSet(int n)
        {
            size = new int[n];
            par = new int[n];
            Arrays.fill(size, 1);
            for(int i=0; i<n; i++)
            {
                par[i] = i;
            }
        }
        public int find(int u)
        {
            return par[u] = par[u] == u ? u : find(par[u]);
        }
        public void union(int u, int v)
        {
            int uParent = find(u);
            int vParent = find(v);
            if(uParent == vParent)
            {
                return;
            }
            if(size[uParent] >= size[vParent])
            {
                size[uParent] += size[vParent];
                par[vParent] = uParent;
            }
            else
            {
                size[vParent] += size[uParent];
                par[uParent] = vParent;
            }
        }
    }
}