class Solution {
    public int removeStones(int[][] stones) {
        int m = stones.length;
        int n = stones[0].length;
        int maxRow = 0;
        int maxCol = 0;
        for(int[] stone : stones)
        {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        maxRow++;
        maxCol++;
        DisjointSet ds = new DisjointSet(maxRow + maxCol);
        for(int[] stone : stones)
        {
            ds.union(stone[0], maxRow + stone[1]);
        }
        return stones.length - ds.getNumberOfComponents();
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        public DisjointSet(int n)
        {
            parent = new int[n];
            size= new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
        }
        private int findParent(int u)
        {
            return (parent[u] == u ? u : findParent(parent[u]));
        }
        public void union(int u, int v)
        {
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent)
            {
                return;
            }
            if(size[uParent] == 0)
            {
                size[uParent] = 1;
            }
            if(size[vParent] == 0)
            {
                size[vParent] = 1;
            }
            if(size[uParent] > size[vParent])
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
        public int getNumberOfComponents()
        {
            int count = 0;
            for(int i=0; i<parent.length; i++)
            {
                if(findParent(i) == i && size[findParent(i)] > 0)
                {
                    count++;
                }
            }
            return count;
        }
    }
}