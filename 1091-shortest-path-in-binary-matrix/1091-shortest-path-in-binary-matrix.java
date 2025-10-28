class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length-1][grid.length-1] == 1)
        {
            return -1;
        }
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] { 0,0 });
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int length = 0;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        visited[0][0] = true;
        while(q.size() > 0)
        {
            length++;
            int s = q.size();
            for(int i=0; i<s; i++)
            {
                int[] top = q.poll();
                int r = top[0];
                int c = top[1];
                if(r == n-1 && c == n-1)
                {
                    return length;
                }
                for(int[] d : dirs)
                {
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(nr < 0 || nr == n || nc < 0 || nc == n || visited[nr][nc] || grid[nr][nc] == 1)
                    {
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return -1;
    }
}