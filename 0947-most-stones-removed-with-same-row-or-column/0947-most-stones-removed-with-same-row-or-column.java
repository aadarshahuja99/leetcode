class Solution {
    public int removeStones(int[][] stones) {
        // the max no of stones that can be removed are the n - number of components. Here, a component is a set of stones that either share a row or a column.
        int max = 0;
        for(int i=0; i<stones.length; i++)
        {
            max = Math.max(max,stones[i][0]);
            max = Math.max(max,stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(stones,max);
        for(int i=0; i<stones.length; i++)
        {
            for(int j=0; j<stones.length; j++)
            {
                if(i==j)
                {
                    continue;
                }
                int keyi = stones[i][0]*(max+1) + stones[i][1];
                int keyj = stones[j][0]*(max+1) + stones[j][1];
                ds.connect(keyi,keyj);
            }
        }
        return stones.length - ds.getComponents();
    }
    class DisjointSet
    {
        private int[] parent;
        private HashMap<Integer,Integer> size;
        int mat = 0;
        public DisjointSet(int[][] stones,int max)
        {
            int n = max+1;
            mat = n;
            parent = new int[n*n];
            Arrays.fill(parent,-1);
            size = new HashMap<Integer,Integer>();
            for(int[] stone : stones)
            {
                int i=stone[0];
                int j=stone[1];
                int key = i*n+j;
                parent[key] = key;
                size.put(key,1);
            }
        }
        private int findParent(int u)
        {
            int temp = u;
            while(temp != parent[temp])
            {
                temp = parent[temp];
            }
            parent[u] = temp;
            return temp;
        }
        public void connect(int u, int v)
        {
            int r1 = u/mat;
            int c1 = u%mat;
            int r2= v/mat;
            int c2 = v%mat;
            if(r1 == r2 || c1 == c2)
            {
                int parU = findParent(u);
                int parV = findParent(v);
                if(parU == parV)
                {
                    return;
                }
                if(size.get(parU) < size.get(parV))
                {
                    parent[parU] = parV;
                    int newSize = size.get(parV)+size.get(parU);
                    size.replace(parV,newSize);
                }
                else
                {
                    parent[parV] = parU;
                    int newSize = size.get(parU)+size.get(parV);
                    size.replace(parU,newSize);
                }
            }
        }
        public int getComponents()
        {
            int ans = 0;
            for(int i=0; i<parent.length; i++)
            {
                if(parent[i] == i)
                {
                    ans++;
                }
            }
            return ans;
        }
    }
}