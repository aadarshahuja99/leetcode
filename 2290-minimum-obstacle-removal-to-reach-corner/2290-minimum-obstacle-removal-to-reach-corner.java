class Solution {
    public int minimumObstacles(int[][] grid) {
        // apply dijkstra's algorithm
        int m = grid.length;
        int n = grid[0].length;
        int[][] distances = new int[m][n];
        int[] dr = new int[] { 0,1,0,-1 };
        int[] dc = new int[] { 1,0,-1,0 };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b)
            {
                return a[2] - b[2];
            }
        });
        for(int[] row : distances)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        pq.add(new int[] { 0,0,0 });
        while(pq.size() > 0)
        {
            var top = pq.poll();
            var row = top[0];
            var col = top[1];
            int currentDistance = top[2];
            for(int i=0; i<4; i++)
            {
                int newRow = dr[i] + row;
                int newCol = dc[i] + col;
                int candidateDistance = currentDistance;
                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol <n)
                {
                    if(grid[newRow][newCol] == 1)
                    {
                        candidateDistance += 1;
                    }
                    if(candidateDistance < distances[newRow][newCol])
                    {
                        distances[newRow][newCol] = candidateDistance;
                        pq.add(new int[] { newRow, newCol, candidateDistance });
                    }
                }
            }
        }
        return distances[m-1][n-1];
    }
}