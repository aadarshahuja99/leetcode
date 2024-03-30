class Solution {
    public int shortestPath(int[][] grid, int k) {
        // dijstra's algorithm
        int m = grid.length;
        int n = grid[0].length;
        int[][] distances = new int[m][n];
        for(int[] row : distances)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        int[] dr = new int[] { 0,1,0,-1 };
        int[] dc = new int[] { 1,0,-1,0 };  
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { 0,0,0,0 });
        while(queue.size() > 0)
        {
            var top = queue.poll();
            int currentDistance = top[2];
            int row = top[0];
            int col = top[1];
            for(int i=0; i<4; i++)
            {
                int removed = top[3];
                int newRow = row + dr[i];
                int newCol = col + dc[i];
                int candidate = currentDistance + 1;
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                {
                    if(grid[newRow][newCol] == 1)
                    {
                        removed += 1;
                    }
                    if(candidate < distances[newRow][newCol] && removed <= k)
                    {
                        distances[newRow][newCol] = candidate;
                        queue.add(new int[] { newRow, newCol, candidate, removed });
                    }
                }
            }
        }
        if(distances[m-1][n-1] == Integer.MAX_VALUE)
        {
            return -1;
        }
        return distances[m-1][n-1];
    }
}