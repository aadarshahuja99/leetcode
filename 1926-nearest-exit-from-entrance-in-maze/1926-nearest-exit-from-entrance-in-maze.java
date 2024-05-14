class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int distance = 0;
        queue.add(new int[] { entrance[0], entrance[1] });
        visited[entrance[0]][entrance[1]] = true;
        while(queue.size() > 0)
        {
            distance++;
            int size = queue.size();
            for(int it = 0; it < size; it++)
            {
                int[] top = queue.poll();
                int row = top[0];
                int col = top[1];
                if((row == 0 || row == m-1 || col == 0 || col == n-1) && !(row == entrance[0] && col == entrance[1]))
                {
                    return distance - 1;
                }
                int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
                for(int i=0; i<4; i++)
                {
                    int newRow = row + delta[i][0];
                    int newCol = col + delta[i][1];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n)
                    {
                        if(maze[newRow][newCol] != '+' && !visited[newRow][newCol])
                        {
                            visited[newRow][newCol] = true;
                            queue.add(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }
        return -1;
    }
}