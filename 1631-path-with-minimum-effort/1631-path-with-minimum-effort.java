class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] row : dist)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2];
        });
        pq.add(new int[] { 0, 0, 0 });
        int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        boolean[][] v = new boolean[m][n];
        while(pq.size() > 0)
        {
            var top = pq.poll();
            int d = top[2];
            int r = top[0];
            int c = top[1];
            if(r == m-1 && c == n-1)
            {
                return d;
            }
            if(v[r][c])
            {
                continue;
            }
            v[r][c] = true;
            for(int[] dir : DIRS)
            {
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr < 0 || nr == m || nc < 0 || nc == n || v[nr][nc])
                {
                    continue;
                }
                int currentJump = Math.abs(heights[nr][nc] - heights[r][c]);
                if(Math.max(currentJump,d) < dist[nr][nc])
                {
                    dist[nr][nc] = currentJump;
                    pq.add(new int[] { nr, nc, Math.max(currentJump, d) });
                }
            }
        }
        return -1;
    }
}