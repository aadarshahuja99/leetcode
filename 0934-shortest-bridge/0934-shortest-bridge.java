class Solution {
    private static int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid.length;
        HashSet<List<Integer>> boundary = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        boolean firstVisited = false;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    dfs(i, j, grid, visited, boundary);
                    firstVisited = true;
                    break;
                }
            }
            if(firstVisited)
            {
                break;
            }
        }
        // for(int i=0; i<m; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         System.out.print(visited[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        Queue<int[]> queue = new LinkedList<>();
        for(List<Integer> pos : boundary)
        {
            queue.add(new int[] { pos.get(0), pos.get(1), 0 });
        }
        while(queue.size() > 0)
        {
            int[] top = queue.poll();
            int r = top[0];
            int c = top[1];
            int d = top[2];
            for(int[] dir : delta)
            {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nr >= m || nc < 0 || nc >= n)
                {
                    continue;
                }
                if(grid[nr][nc] == 1 && !visited[nr][nc])
                {
                    return d;
                }
                if(grid[nr][nc] == 0 && !visited[nr][nc])
                {
                    visited[nr][nc] = true;
                    queue.add(new int[] { nr, nc, d+1 });
                }
            }
        }
        return -1;
    }
    private void dfs(int r, int c, int[][] grid, boolean[][] visited, HashSet<List<Integer>> boundary)
    {
        visited[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        for(int[] dir : delta)
        {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc])
            {
                continue;
            }
            if(grid[nr][nc] == 0)
            {
                ArrayList<Integer> pos = new ArrayList<>();
                pos.add(r);
                pos.add(c);
                boundary.add(pos);
            }
            else
            {
                dfs(nr, nc, grid, visited, boundary);
            }
        }
    }
}