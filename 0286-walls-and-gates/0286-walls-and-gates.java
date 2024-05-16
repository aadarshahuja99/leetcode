class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(rooms[i][j] == 0)
                {
                    queue.add(new int[] { i,j });
                }
            }
        }
        int distance = 0;
        while(queue.size() > 0)
        {
            distance++;
            int size = queue.size();
            for(int it=0; it<size; it++)
            {
                var top = queue.poll();
                int r = top[0];
                int c = top[1];
                int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};
                for(int i=0; i<4; i++)
                {
                    int newRow = r + delta[i][0];
                    int newCol = c + delta[i][1];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == Integer.MAX_VALUE)
                    {
                        rooms[newRow][newCol] = distance;
                        queue.add(new int[] { newRow, newCol });
                    }
                }
            }
        }
    }
}