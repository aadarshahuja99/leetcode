class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        Queue<int[]> bfsQueue = new LinkedList<>();
        boolean[][] vis = new boolean[r][c];
        // top
        for(int i=0; i<c; i++)
        {
            if(board[0][i] == 'O' && !vis[0][i])
            {
                bfsQueue.add(new int[] { 0, i });
                vis[0][i] = true;
            }
        }

        // bottom
        for(int i=0; i<c; i++)
        {
            if(board[r-1][i] == 'O' && !vis[r-1][i])
            {
                bfsQueue.add(new int[] { r-1, i });
                vis[r-1][i] = true;
            }
        }

        // left
        for(int i=0; i<r; i++)
        {
            if(board[i][0] == 'O' && !vis[i][0])
            {
                bfsQueue.add(new int[] { i, 0 });
                vis[i][0] = true;
            }
        }

        // left
        for(int i=0; i<r; i++)
        {
            if(board[i][c-1] == 'O' && !vis[i][c-1])
            {
                bfsQueue.add(new int[] { i, c-1 });
                vis[i][c-1] = true;
            }
        }
        int[][] DIRS = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        while(bfsQueue.size() > 0)
        {
            var top = bfsQueue.poll();
            int i = top[0];
            int j = top[1];
            for(int[] d : DIRS)
            {
                int nr = i + d[0];
                int nc = j + d[1];
                if(nr < 0 || nr == r || nc < 0 || nc == c || vis[nr][nc] || board[nr][nc] == 'X')
                {
                    continue;
                }
                bfsQueue.add(new int[] { nr, nc });
                vis[nr][nc] = true;
            }
        }
        for(int i=0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(!vis[i][j])
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}