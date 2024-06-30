class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int totalCells = m*n;
        int queries = positions.length;
        DisjointSet ds = new DisjointSet(totalCells, queries);
        int[][] grid = new int[m][n];
        List<Integer> ans = new ArrayList<>();
        boolean[] marked = new boolean[m*n];
        int current = 0;
        int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int[] position : positions)
        {
            int currentValue = position[0]*n + position[1];
            if(marked[currentValue])
            {
                ans.add(current);
                continue;
            }
            marked[currentValue] = true;
            current++;
            HashSet<Integer> neighbors = new HashSet<>();
            for(int[] change : delta)
            {
                int newRow = position[0] + change[0];
                int newCol = position[1] + change[1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || grid[newRow][newCol] == 0)
                {
                    continue;
                }
                neighbors.add(ds.findParent(n*newRow + newCol));
            }
            for(int neighbor : neighbors)
            {
                ds.union(neighbor, currentValue);
            }
            grid[position[0]][position[1]] = 1;
            current -= neighbors.size();
            ans.add(current);
        }
        return ans;
    }
    class DisjointSet
    {
        int[] parent;
        int[] size;
        int components;
        public DisjointSet(int n, int q)
        {
            parent = new int[n];
            size = new int[n];
            components = q;
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
            }
            Arrays.fill(size, 1);
        }
        int findParent(int u)
        {
            return parent[u] = (parent[u] == u ? u : findParent(parent[u]));
        }
        void union(int u, int v)
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
            components--;
        }
        int getComponents()
        {
            return components;
        }
    }
}