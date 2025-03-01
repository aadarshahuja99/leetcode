class Solution {
    public int maxDistance(int[][] grid) {
        int ans = -1;
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int[] r : dist)
        {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    q.add(new int[] { i, j });
                    dist[i][j] = 0;
                }
            }
        }
        if(q.size() == 0 || q.size() == n*n)
        {
            return ans;
        }
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int steps = 0;
        while(q.size() > 0)
        {
            int s = q.size();
            steps++;
            for(int i=0; i<s; i++)
            {
                int[] top = q.poll();
                for(int[] d : dirs)
                {
                    int nr = d[0] + top[0];
                    int nc = d[1] + top[1];
                    if(nr < 0 || nr == n || nc < 0 || nc == n)
                    {
                        continue;
                    }
                    if(dist[nr][nc] == Integer.MAX_VALUE)
                    {
                        dist[nr][nc] = steps;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }
        return steps-1;
    }
}