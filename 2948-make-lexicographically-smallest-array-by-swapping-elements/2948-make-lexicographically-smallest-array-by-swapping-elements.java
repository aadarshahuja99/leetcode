class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);
        int it=0;
        int[][] indexedList = new int[nums.length][2];
        for(int num : nums)
        {
            indexedList[it][0] = it;
            indexedList[it][1] = num;
            it++;
        }
        it=0;
        Arrays.sort(indexedList, new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[1] - b[1];
            }
        });
        while(it < nums.length)
        {
            int j=it+1;
            while(j < nums.length && indexedList[j][1] - indexedList[j-1][1] <= limit)
            {
                ds.union(indexedList[j][0], indexedList[j-1][0]);
                j++;
            }
            it=j;
        }
        var groups = ds.getGroups();
        if(groups.size() == 0)
        {
            return nums;
        }
        int[] sorted = new int[n];
        for(ArrayList<Integer> group : groups)
        {
            int[] current = new int[group.size()];
            int idx = 0;
            for(int i : group)
            {
                current[idx] = nums[i];
                idx++;
            }
            Arrays.sort(current);
            idx = 0;
            for(int i : group)
            {
                sorted[i] = current[idx];
                idx++;
            }
        }
        return sorted;
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        public DisjointSet(int n)
        {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size,1);
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }
        private int find(int u)
        {
            return parent[u] = (parent[u] == u ? u : find(parent[u]));
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
                parent[vParent] = uParent;
            }
            else
            {
                size[vParent] += size[uParent];
                parent[uParent] = vParent;
            }
        }
        public ArrayList<ArrayList<Integer>> getGroups()
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
            for(int i=0; i<parent.length; i++)
            {
                int p = find(i);
                if(!map.containsKey(p))
                {
                    ArrayList<Integer> children = new ArrayList<>();
                    children.add(i);
                    map.put(p, children);
                }
                else
                {
                    map.get(p).add(i);
                }
            }
            for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet())
            {
                // System.out.println(entry.getValue().toString());
                list.add(entry.getValue());
            }
            return list;
        }
    }
}