class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // naming this as memo, because we are memoizing the shortest path encountered so far. This is not the same as dp.
        // In dp, we traverse to the final state (explore the entire current path), and, then decide. Here, we look back in time and not look forward.
        // In a way, this is greedy plus memoization
        int[][][] memo = new int[m][n][k+1];
        for(int[][] mat : memo)
        {
            for(int[] row : mat)
            {
                Arrays.fill(row,Integer.MAX_VALUE);
            }
        }
        for(int i=0; i<=k; i++)
        {
            memo[0][0][i] = 0;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { 0,0,k });
        int[] dr = new int[] { 0,1,0,-1 };
        int[] dc = new int[] { 1,0,-1,0 };
        int dist = 0;
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
                for(int j=0; j<4; j++)
                {
                    int newRow = row + dr[j];
                    int newCol = col + dc[j];
                    if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n)
                    {
                        continue;
                    }
                    if(grid[newRow][newCol] == 0 && memo[newRow][newCol][obs] > dist)
                    {
                        memo[newRow][newCol][obs] = dist;
                        // System.out.println("pushing "+dist+" to queue for "+newRow+" "+newCol+" from "+row+" "+col+" "+obs);
                        queue.add(new int[] { newRow,newCol,obs });
                    }
                    if(obs > 0 && grid[newRow][newCol] == 1 && memo[newRow][newCol][obs-1] > dist)
                    {
                        memo[newRow][newCol][obs-1] = dist;
                        // System.out.println("pushing "+dist+" to queue for "+newRow+" "+newCol+" from "+row+" "+col+" "+obs);
                        queue.add(new int[] { newRow,newCol,obs-1 });
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=k; i++)
        {
            min = Math.min(memo[m-1][n-1][i], min);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}