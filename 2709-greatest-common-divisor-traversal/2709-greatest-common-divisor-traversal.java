class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // union find + prime factorization
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int idx = 0;
        for(int num : nums)
        {
            updatePrimeFactorMap(num, idx, map);
            idx++;
        }
        int n = nums.length;
        DisjointSet ds = new DisjointSet(n);
        for(var entry : map.entrySet())
        {
            int factor = entry.getKey();
            if(entry.getValue().size() == 1)
            {
                continue;
            }
            var numbers = entry.getValue();
            for(int i=0; i<numbers.size()-1; i++)
            {
                ds.union(numbers.get(i), numbers.get(i+1));
            }
        }
        return ds.getComponents() == 1;
    }

    private void updatePrimeFactorMap(int number, int idx, HashMap<Integer,ArrayList<Integer>> map)
    {
        int num = number;
        if(num%2 == 0)
        {
            while(num%2 == 0)
            {
                num = num/2;
            }
            if(!map.containsKey(2))
            {
                map.put(2, new ArrayList<>());
            }
            // System.out.println(idx+ " to 2");
            map.get(2).add(idx);
        }
        for(int i=3; i*i <= num; i+=2)
        {
            if(num%i == 0)
            {
                if(!map.containsKey(i))
                {
                    // System.out.println(idx+ " to "+ num);
                    map.put(i, new ArrayList<>());
                }
                map.get(i).add(idx);
            }
            while(num%i == 0)
            {
                num = num/i;
            }
        }
        if(num > 0)
        {
            if(!map.containsKey(num))
            {
                map.put(num, new ArrayList<>());
            }
            // System.out.println(idx+ " to "+ num);
            map.get(num).add(idx);
        }
    }

    class DisjointSet
    {
        int[] parent;
        int[] size;
        int numComponents;
        public DisjointSet(int n)
        {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
            numComponents = n;
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
                parent[uParent] = vParent;
                size[vParent] += size[uParent];
            }
            numComponents--;
        }

        public int getComponents()
        {
            return numComponents;
        }
    }
}