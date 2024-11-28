class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int k) {
        int m = grid.size();
        int n = grid.get(0).size();
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] v = new boolean[m][n][k+1];
        q.add(new int[] { 0, 0, grid.get(0).get(0) });
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(q.size() > 0)
        {
            int[] top = q.poll();
            int r = top[0];
            int c = top[1];
            int currentObs = top[2];
            // System.out.println(current+" "+currentObs+" for "+r+" "+c);
            if(v[r][c][currentObs])
            {
                continue;
            }
            v[r][c][currentObs] = true;
            if(r == m-1 && c == n-1 && k - currentObs >= 1)
            {
                return true;
            }
            for(int[] d : dirs)
            {
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr < 0 || nr == m || nc < 0 || nc == n)
                {
                    continue;
                }
                int addedCost = grid.get(nr).get(nc);
                if(currentObs + addedCost < k && !v[nr][nc][currentObs + addedCost])
                {
                    q.add(new int[] { nr, nc, addedCost + currentObs });
                }
            }
        }
        return false;
    }
}