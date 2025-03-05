class Solution {
    public int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[0][1] > 1 && grid[1][0] > 1)
        {
            return -1;
        }
        long[][] distance = new long[rows][cols];
        for(long[] row : distance)
        {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((long[] a, long[] b) -> {
            return Long.compare(a[2], b[2]);
        });
        pq.add(new long[] { 0, 0, 0l });
        distance[0][0] = 0;
        boolean[][] vis = new boolean[rows][cols];
        int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(pq.size() > 0)
        {
            long[] top = pq.poll();
            int r = (int)top[0];
            int c = (int)top[1];
            if(r == rows-1 && c == cols-1)
            {
                return (int)top[2];
            }
            if(vis[r][c])
            {
                continue;
            }
            vis[r][c] = true;
            long time = top[2];
            for(int[] d : delta)
            {
                int nr = d[0] + r;
                int nc = d[1] + c;
                if(nr == rows || nc == cols || nr < 0 || nc < 0)
                {
                    continue;
                }
                if(vis[nr][nc])
                {
                    continue;
                }
                long newCost = 0l;
                if(time < grid[nr][nc])
                {
                    int addedCost = (grid[nr][nc] - time)%2 == 0 ? 1 : 0;
                    newCost = grid[nr][nc]*1l + addedCost;
                }
                else
                {
                    newCost = time + 1l;
                }
                if(newCost < distance[nr][nc])
                {
                    pq.add(new long[] { nr, nc, newCost });
                }
            }
        }
        return -1;
    }
}