class Solution {
    public int minimumObstacles(int[][] grid) {
        // dijkstra
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2];
        });
        boolean[][] v = new boolean[m][n];
        pq.add(new int[] { 0, 0, 0 });
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(pq.size() > 0)
        {
            int[] top = pq.poll();
            int r = top[0];
            int c = top[1];
            int current = top[2];
            // System.out.println(current+" for "+r+" "+c);
            if(v[r][c])
            {
                continue;
            }
            cost[r][c] = current;
            v[r][c] = true;
            for(int[] d : dirs)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nr == m || nc < 0 || nc == n || v[nr][nc])
                {
                    continue;
                }
                int addedCost = grid[nr][nc];
                pq.add(new int[] { nr, nc, addedCost + current });
            }
        }
        return cost[m-1][n-1];
    }
}