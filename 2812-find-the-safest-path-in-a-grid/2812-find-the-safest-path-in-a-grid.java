class Solution {
    static final int[][] delta = { {0,1}, {1,0}, {0,-1}, {-1,0} };
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // do a multisource bfs, then do a BS on answer to find the ans
        int m = grid.size();
        int n = grid.get(0).size();
        if(grid.get(0).get(0) == 1 || grid.get(m-1).get(n-1) == 1)
        {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] distanceGrid = new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid.get(i).get(j) == 1)
                {
                    queue.add(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }
        int dist = 0;
        while(queue.size() > 0)
        {
            dist++;
            int size = queue.size();
            for(int it=0; it<size; it++)
            {
                var top = queue.poll();
                int row = top[0];
                int col = top[1];
                for(int i=0; i<4; i++)
                {
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow >= m || newRow < 0 || newCol >= n || newCol < 0 || visited[newRow][newCol])
                    {
                        continue;
                    }
                    distanceGrid[newRow][newCol] = dist;
                    // System.out.println(dist+" "+newRow+" "+newCol);
                    visited[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol });
                }
            }
        }

        // apply BS on answer
        int start = 0;
        int end = dist-1;
        int ans = -1;
        System.out.println(end);
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(check(mid, distanceGrid, m, n))
            {
                ans = mid;
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[][] distanceGrid, int m, int n)
    {
        boolean[][] visited = new boolean[m][n];
        if(distanceGrid[0][0] < guess)
        {
            return false;
        }
        return dfs(0, 0, distanceGrid, visited, guess, m, n);
    }
    private boolean dfs(int row, int col, int[][] distanceGrid, boolean[][] visited, int distance, int m, int n)
    {
        visited[row][col] = true;
        boolean ans = false;
        for(int i = 0; i < 4; i++)
        {
            int newRow = row + delta[i][0];
            int newCol = col + delta[i][1];
            if(newRow >= m || newRow < 0 || newCol >= n || newCol < 0 || visited[newRow][newCol]
                || distanceGrid[newRow][newCol] < distance)
            {
                continue;
            }
            if(newRow == m-1 && newCol == n-1)
            {
                return true;
            }
            ans = ans || dfs(newRow, newCol, distanceGrid, visited, distance, m, n);
            if(ans)
            {
                return ans;
            }
        }
        return ans;
    }
}