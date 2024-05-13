class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // 0-1 bfs from the start position to the dest
        Queue<int[]> queue = new LinkedList<>();
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        queue.add(start);
        int[][] distances = new int[m][n];
        for(int[] row : distances)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distances[start[0]][start[1]] = 0;
        while(queue.size() > 0)
        {
            int size = queue.size();
            for(int i=0; i<size; i++)
            {
                var top = queue.poll();
                int row = top[0];
                int col = top[1];
                int[][] delta = {{0,1}, {1,0}, {-1,0}, {0,-1}};
                for(int it=0; it<4; it++)
                {
                    int newRow = delta[it][0] + row;
                    int newCol = delta[it][1] + col;
                    int countInDirection = 0;
                    while(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == 0)
                    {
                        newRow += delta[it][0];
                        newCol += delta[it][1];
                        countInDirection++;
                    }
                    if(distances[newRow - delta[it][0]][newCol - delta[it][1]] > distances[row][col] + countInDirection)
                    {
                        distances[newRow - delta[it][0]][newCol - delta[it][1]] = distances[row][col] + countInDirection;
                        queue.add(new int[] { newRow - delta[it][0], newCol - delta[it][1] });
                    }
                }
            }
        }
        return distances[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distances[destination[0]][destination[1]];
    }
}