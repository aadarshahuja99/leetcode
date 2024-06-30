class Solution {
    public boolean gcdSort(int[] nums) {
        var clone = nums.clone();
        Arrays.sort(clone);
        HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
        for(int num : nums)
        {
            int temp = num;
            if(num%2 == 0)
            {
                if(!map.containsKey(2))
                {
                    map.put(2, new LinkedHashSet<>());
                }
                map.get(2).add(temp);
                while(num%2 == 0)
                {
                    num = num/2;
                }
            }
            for(int i=3; i<num; i+=2)
            {
                if(num%i == 0)
                {
                    if(!map.containsKey(i))
                    {
                        map.put(i, new LinkedHashSet<>());
                    }
                    map.get(i).add(temp);
                    while(num%i == 0)
                    {
                        num = num/i;
                    }
                }
            }
            if(num > 1)
            {
                if(!map.containsKey(num))
                {
                    map.put(num, new LinkedHashSet<>());
                }
                map.get(num).add(temp);
            }
        }
        DisjointSet ds = new DisjointSet();
        for(var entry : map.entrySet())
        {
            Integer[] arr = new Integer[entry.getValue().size()];
            arr = entry.getValue().toArray(arr);
            if(arr.length > 1)
            {
                int idx = 0;
                for(int num : arr)
                {
                    if(idx > 0)
                    {
                        ds.union(num, arr[idx-1]);
                    }
                    idx++;
                }
            }
        }
        int it=0;
        for(int c : clone)
        {
            // System.out.println(c+" "+nums[it]+" "+ds.find(c)+" "+ds.find(nums[it]));
            if(ds.find(c) != ds.find(nums[it]))
            {
                return false;
            }
            it++;
        }
        return true;
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        public DisjointSet()
        {
            parent = new int[100001];
            size = new int[100001];
            for(int i=0; i<100001; i++)
            {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }
        public int find(int u)
        {
            return parent[u] = (u == parent[u] ? u : find(parent[u]));
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
                parent[vParent] = uParent;
                size[uParent] += size[vParent];
            }
            else
            {
                parent[uParent] = vParent;
                size[vParent] += size[uParent];
            }
        }
    }
}