class Solution {
    public int largestComponentSize(int[] nums) {
        HashMap<Integer,HashSet<Integer>> adj = new HashMap<>();
        HashMap<Integer,Integer> idxMap = new HashMap<>();
        int idx = 0;
        for(int num : nums)
        {
            updateMap(num, adj);
            idxMap.put(num, idx);
            idx++;
        }
        DisjointSet ds = new DisjointSet(nums);
        for(var entry : adj.entrySet())
        {
            int first = 0;
            // System.out.println("for key: "+entry.getKey());
            for(int num : entry.getValue())
            {
                // System.out.println("current val from nums = "+num);
                if(first == 0)
                {
                    first = num;
                }
                else
                {
                    ds.union(idxMap.get(first), idxMap.get(num));
                }
            }
            // System.out.println();
        }
        return ds.getAns();
    }
    private void updateMap(int current, HashMap<Integer,HashSet<Integer>> adj)
    {
        int temp = current;
        if(current%2 == 0)
        {
            if(adj.containsKey(2))
            {
                adj.get(2).add(temp);
            }
            else
            {
                adj.put(2, new HashSet<>());
                adj.get(2).add(temp);
            }
            while(current%2 == 0)
            {
                current = current/2;
            }
        }
        for(int i=3; i*i <= current; i+=2)
        {
            if(current%i == 0)
            {
                if(adj.containsKey(i))
                {
                    adj.get(i).add(temp);
                }
                else
                {
                    adj.put(i, new HashSet<>());
                    adj.get(i).add(temp);
                }
                while(current%i == 0)
                {
                    current = current/i;
                }
            }
        }
        if(current > 2)
        {
            if(adj.containsKey(current))
            {
                adj.get(current).add(temp);
            }
            else
            {
                adj.put(current, new HashSet<>());
                adj.get(current).add(temp);
            }
        }
    }
    class DisjointSet
    {
        int[] size;
        int[] parent;
        int largestComponentSize;
        public DisjointSet(int[] nums)
        {
            largestComponentSize = 1;
            int n = nums.length;
            size = new int[n];
            parent = new int[n];
            Arrays.fill(size, 1);
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }
        public int findParent(int u)
        {
            if(u == parent[u])
            {
                return u;
            }
            return (parent[u] = findParent(parent[u]));
        }
        public void union(int u, int v)
        {
            int u_parent = findParent(u);
            int v_parent = findParent(v);
            if(u_parent == v_parent)
            {
                return;
            }
            if(size[u_parent] >= size[v_parent])
            {
                size[u_parent] += size[v_parent];
                parent[v_parent] = u_parent;
                size[v_parent] = 0;
                largestComponentSize = Math.max(largestComponentSize, size[u_parent]);
                // System.out.println("condition1: size of u_parent = "+size[u_parent]+" u_parent= "+u_parent+" u= "+u+" v= "+v);
            }
            else
            {
                size[v_parent] += size[u_parent];
                parent[u_parent] = v_parent;
                size[u_parent] = 0;
                largestComponentSize = Math.max(largestComponentSize, size[v_parent]);
                // System.out.println("condition2: size of v_parent = "+size[v_parent]+" v_parent= "+v_parent+" u= "+u+" v= "+v);
            }
        }
        public int getAns()
        {
            return largestComponentSize;
        }
    }
}