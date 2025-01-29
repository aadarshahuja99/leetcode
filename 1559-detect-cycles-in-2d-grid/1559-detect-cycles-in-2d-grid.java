class Solution {
    DisjointSet ds;
    public boolean containsCycle(char[][] grid) {
        int size = grid.length * grid[0].length;
        ds = new DisjointSet(size);
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] vis = new boolean[r][c];
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(!vis[i][j] && dfs(i, j, -1, -1, vis, grid))
                {
                    return true;
                }
                // System.out.println("not found from "+i+" , "+j);
            }
        }
        return false;
    }
    private boolean dfs(int r, int c, int pr, int pc, boolean[][] vis, char[][] grid)
    {
        vis[r][c] = true;
        int[][] DIRs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int val1 = r*grid[0].length + c;
        for(int[] d : DIRs)
        {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr < 0 || nr == grid.length || nc < 0 || nc == grid[0].length || grid[nr][nc] != grid[r][c] || (pr == nr && pc == nc))
            {
                continue;
            }
            int val2 = nr*grid[0].length + nc;
            if(vis[nr][nc])
            {
                // System.out.println("found for "+nr+", "+nc+" and "+r+", "+c);
                return true;
            }
            if(dfs(nr, nc, r, c, vis, grid))
            {
                return true;
            }
        }
        return false;
    }
    class DisjointSet
    {
        private int[] p;
        private int[] s;
        int size;
        DisjointSet(int n)
        {
            size = n;
            p = new int[n];
            s = new int[n];
            Arrays.fill(s, 1);
            for(int i=0; i<n; i++)
            {
                p[i] = i;
            }
        }
        public int find(int u)
        {
            return p[u] = p[u] == u ? u : find(p[u]);
        }
        public void union(int u, int v)
        {
            int uParent = find(u);
            int vParent = find(v);
            if(uParent == vParent)
            {
                return;
            }
            if(s[uParent] <= s[vParent])
            {
                s[vParent] += s[uParent];
                p[uParent] = p[vParent];
            }
            else
            {
                s[uParent] += s[vParent];
                p[vParent] = p[uParent];
            }
        }
    }
}