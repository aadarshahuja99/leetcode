class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // naming this as memo, because we are memoizing the shortest path encountered so far. This is not the same as dp.
        // In dp, we traverse to the final state (explore the entire current path), and, then decide. Here, we look back in time and not look forward.
        // In a way, this is greedy plus memoization
        // int[][] memo = new int[m][n];
        // for(int[] row : mat)
        // {
        //     Arrays.fill(row,Integer.MAX_VALUE);
        // }
        // for(int i=0; i<=k; i++)
        // {
        //     memo[0][0][i] = 0;
        // }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { 0,0,k });
        int[] dr = new int[] { 0,1,0,-1 };
        int[] dc = new int[] { 1,0,-1,0 };
        int dist = 0;
        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][k] = true;
        for(int i=0; i<=k; i++)
        {
            visited[0][0][i] = true;
        }
        while(queue.size() > 0)
        {
            int size = queue.size();
            dist++;
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                int row = top[0];
                int col = top[1];
                int obs = top[2];
                if(row == m-1 && col == n-1)
                {
                    return dist - 1;
                }
                for(int j=0; j<4; j++)
                {
                    int newRow = row + dr[j];
                    int newCol = col + dc[j];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                    {
                        continue;
                    }
                    int candidateDistance = grid[newRow][newCol];
                    if(grid[newRow][newCol] == 1 && obs >= 1 && !visited[newRow][newCol][obs-1])
                    {
                        visited[newRow][newCol][obs-1] = true;
                        // System.out.println(dist+" pushing: "+newRow+" "+newCol+" "+(obs-1));
                        queue.add(new int[] { newRow, newCol, obs-1 });
                    }
                    else if(grid[newRow][newCol] == 0 && !visited[newRow][newCol][obs])
                    {
                        visited[newRow][newCol][obs] = true;
                        // System.out.println(dist+" pushing: "+newRow+" "+newCol+" "+(obs));
                        queue.add(new int[] { newRow, newCol, obs });
                    }
                }
            }
        }
        return -1;
    }
}