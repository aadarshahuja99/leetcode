class Solution {
    DisjointSet ds;
    public int findMaxFish(int[][] grid) {
        ds = new DisjointSet(grid.length*grid[0].length, grid);
        int[][] visited = new int[grid.length][grid[0].length];
        int rec = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[0].length; j++)
            {
                if(visited[i][j] == 0 && grid[i][j] != 0)
                {
                    dfs(i,j,visited,grid);
                }
            }
        }
        return ds.getMax();
    }
    private void dfs(int i, int j, int[][] visited, int[][] grid)
    {
        visited[i][j] = 1;
        int[] dR = new int[] { -1,0,1,0 };
        int[] dC = new int[] { 0,1,0,-1 };
        int currentKey = i*grid[0].length + j;
        for(int it=0; it<4; it++)
        {
            int newR = i+dR[it];
            int newC = j+dC[it];
            if(newR < grid.length && newR >= 0 && newC < grid[0].length && newC >= 0 && grid[newR][newC] != 0 && visited[newR][newC] != 1)
            {
                int key = newR*grid[0].length + newC;
                ds.union(currentKey, key);
                dfs(newR, newC, visited, grid);
            }
        }
    }
    public class DisjointSet
    {
        private int[] parent;
        private int[] value;
        public DisjointSet(int n, int[][] grid)
        {
            int col = grid[0].length;
            parent = new int[n];
            value = new int[n];
            for(int i=0; i<n; i++)
            {
                parent[i] = i;
                int r = i/col;
                int c = i%col;
                value[i] = grid[r][c];
            }
        }
        public int findParent(int u)
        {
            if(parent[u] == u)
            {
                return u;
            }
            return (parent[u] = findParent(parent[u]));
        }
        public void union(int u, int v)
        {
            int u_parent = findParent(u);
            int v_parent = findParent(v);
            if(value[u_parent] >= value[v_parent])
            {
                parent[v_parent] = u_parent;
                value[u_parent] += value[v_parent];
                value[v_parent] = 0;
            }
            else
            {
                parent[u_parent] = v_parent;
                value[v_parent] += value[u_parent];
                value[u_parent] = 0;
            }
        }
        public int getMax()
        {
            int max = 0;
            for(int v : value)
            {
                max = Math.max(max, v);
            }
            return max;
        }
    }
}