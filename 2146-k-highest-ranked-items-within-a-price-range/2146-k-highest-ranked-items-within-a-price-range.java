class Solution {
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
            if(a[3] == b[3])
            {
                // sort by price or row or col
                if(a[2] == b[2])
                {
                    return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
                }
                // sort by price
                return a[2] - b[2];
            }
            // sort by distance
            return a[3] - b[3];
        });
        int sPrice = pricing[0];
        int ePrice = pricing[1];
        int rows = grid.length;
        int cols = grid[0].length;
        heap.add(new int[] { start[0], start[1], grid[start[0]][start[1]], 0 });
        boolean[][] vis = new boolean[rows][cols];
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int toBeAdded = k;
        while(heap.size() > 0 && toBeAdded > 0)
        {
            var top = heap.poll();
            int r = top[0];
            int c = top[1];
            int dist = top[3];
            int price = top[2];
            if(vis[r][c])
            {
                continue;
            }
            vis[r][c] = true;
            if(price >= sPrice && price <= ePrice)
            {
                ans.add(Arrays.asList(new Integer[] { r, c }));
                toBeAdded--;
            }
            for(int[] d : dirs)
            {
                int nr = d[0] + r;
                int nc = d[1] + c;
                if(nr < 0 || nr == rows || nc < 0 || nc == cols || vis[nr][nc] || grid[nr][nc] == 0)
                {
                    continue;
                }
                heap.add(new int[] { nr, nc, grid[nr][nc], dist + 1 });
            }
        }
        return ans;
    }
}