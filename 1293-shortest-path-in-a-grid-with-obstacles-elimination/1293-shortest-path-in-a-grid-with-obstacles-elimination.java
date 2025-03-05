class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v = new boolean[m][n][k+1];
        q.add(new int[] { 0, 0, 0, 0 });
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int[] row : cost)
        { Arrays.fill(row, Integer.MAX_VALUE); }
        cost[0][0] = 0;
        while(q.size() > 0)
        {
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];
            int currentObs = top[2];
            int current = top[3];
            // System.out.println(current+" "+currentObs+" for "+r+" "+c);
            if(v[r][c][currentObs])
            {
                continue;
            }
            v[r][c][currentObs] = true;
            cost[r][c] = current;
            if(r == m-1 && c == n-1)
            {
                return current;
            }
            for(int[] d : dirs)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nr == m || nc < 0 || nc == n)
                {
                    continue;
                }
                int addedCost = grid[nr][nc];
                if(currentObs + addedCost <= k && !v[nr][nc][currentObs + addedCost])
                {
                    cost[nr][nc] = current+1;
                    q.add(new int[] { nr, nc, addedCost + currentObs, current+1 });
                }
            }
        }
        return -1;
    }
}