class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU ds = new DSU(n*n);
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int ans = 1;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    for(int[] d : dirs)
                    {
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if(nr < 0 || nr == n || nc < 0 || nc == n)
                        {
                            continue;
                        }
                        if(grid[nr][nc] == 1)
                        {
                            ds.union(i*n + j, nr*n + nc);
                            ans = Math.max(ans, ds.getSize(ds.find(i*n + j)));
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    HashSet<Integer> islands = new HashSet<>();
                    for(int[] d : dirs)
                    {
                        int nr = i+d[0];
                        int nc = j+d[1];
                        if(nr < 0 || nr == n || nc < 0 || nc == n || grid[nr][nc] == 0)
                        {
                            continue;
                        }
                        int p = ds.find(nr*n + nc);
                        islands.add(p);
                    }
                    int candidate = 0;
                    for(int p : islands)
                    {
                        candidate += ds.getSize(p);
                    }
                    ans = Math.max(ans, candidate+1);
                }
            }
        }
        return ans;
    }
    class DSU
    {
        int[] p;
        int[] s;
        DSU(int n)
        {
            p = new int[n];
            s = new int[n];
            for(int i=0; i<n; i++)
            {
                p[i] = i;
            }
            Arrays.fill(s, 1);
        }
        int find(int u)
        {
            return p[u] = (p[u] == u ? u : find(p[u]));
        }
        public void union(int u, int v)
        {
            int uParent = find(u);
            int vParent = find(v);
            if(uParent == vParent)
            {
                return;
            }
            if(s[uParent] >= s[vParent])
            {
                s[uParent] += s[vParent];
                p[vParent] = uParent;
            }
            else
            {
                s[vParent] += s[uParent];
                p[uParent] = vParent;
            }
        }
        public int getSize(int node)
        {
            return s[node];
        }
    }
}