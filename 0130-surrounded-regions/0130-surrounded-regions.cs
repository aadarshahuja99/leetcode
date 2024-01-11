public class Solution {
    public void Solve(char[][] board) {
        // intuition: start traversal (bfs or dfs) from 0s that are on the boundary and find all connected zeros four directionally. Preserve these zeros as they are not surrounded by x on atleast one side. Also maintain a visited array to ensure that no zero is visited twice.
        // using bfs
        int n=board.Length;
        int m = board[0].Length;
        int[,] visited = new int[n,m];
        if(n==1 && m==1)
        {
            return;
        }
        Queue<Tuple<int,int>> bfs = new();
        for(int i=0; i<n; i++)
        {
            if(board[i][0] == 'O')
            {
                bfs.Enqueue(Tuple.Create(i,0));
                visited[i,0]=1;
            }
            if(board[i][m-1] == 'O')
            {
                bfs.Enqueue(Tuple.Create(i,m-1));
                visited[i,m-1]=1;
            }
        }
        for(int j=1; j<m-1; j++)
        {
            if(board[0][j] == 'O')
            {
                bfs.Enqueue(Tuple.Create(0,j));
                visited[0,j]=1;
            }
            if(board[n-1][j] == 'O')
            {
                bfs.Enqueue(Tuple.Create(n-1,j));
                visited[n-1,j]=1;
            }
        }
        int[] deltaRow = [1, 0, -1, 0];
        int[] deltaCol = [0, 1, 0, -1];
        while(bfs.Count > 0)
        {
            var top = bfs.Dequeue();
            int row = top.Item1;
            int col = top.Item2;
            for(int k=0; k<4; k++)
            {
                int newRow = row + deltaRow[k];
                int newCol = col + deltaCol[k];
                if(newRow < n && newRow >= 0 && newCol < m && newCol >= 0 && visited[newRow, newCol] == 0 && board[newRow][newCol] == 'O')
                {
                    bfs.Enqueue(Tuple.Create(newRow,newCol));
                    visited[newRow,newCol] = 1;
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(visited[i,j] == 1)
                {
                    board[i][j] = 'O';
                }
                else
                {
                    board[i][j] = 'X';
                }
            }
        }
    }
}