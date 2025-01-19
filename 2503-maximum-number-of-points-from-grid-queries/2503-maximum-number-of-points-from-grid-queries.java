class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int q = queries.length;
        int[][] clone = new int[q][2];
        int idx = 0;
        for(int query : queries)
        {
            clone[idx] = new int[] { query, idx };
            idx++;
        }
        Arrays.sort(clone, (a, b) -> {
            return a[0] - b[0];
        });
        int visited = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[2] - b[2];
        });
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        pq.add(new int[] { 0, 0, grid[0][0] });
        int[] ans = new int[q];
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        vis[0][0] = true;
        for(int[] query : clone)
        {
            int val = query[0];
            int index = query[1];
            // System.out.println("current val = "+val);
            while(pq.size() > 0 && pq.peek()[2] < val)
            {
                int[] top = pq.poll();
                visited++;
                int r = top[0];
                int c = top[1];

                // System.out.println("visiting: "+r+","+c);

                for(int[] dir : dirs)
                {
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;
                    if(nr < 0 || nr == m || nc < 0 || nc == n || vis[nr][nc])
                    {
                        continue;
                    }
                    vis[nr][nc] = true;
                    pq.add(new int[] { nr, nc, grid[nr][nc] });
                }
            }
            ans[index] = visited;
        }
        return ans;
    }
}