public class Solution {
    public int NumEnclaves(int[][] grid) {
        int n=grid.Length;
        int m = grid[0].Length;
        if(n==1 && m==1)
        {
            return 0;
        }
        int[,] visited = new int[n,m];
        Queue<Tuple<int,int>> bfs = new();
        int count = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j] == 1)
                {
                    count++;
                }
            }
        }
        for(int i=0; i<n; i++)
        {
            if(grid[i][0] == 1)
            {
                bfs.Enqueue(Tuple.Create(i,0));
                visited[i,0]=1;
                count--;
            }
            if(m > 1 &&grid[i][m-1] == 1)
            {
                bfs.Enqueue(Tuple.Create(i,m-1));
                visited[i,m-1]=1;
                count--;
            }
        }
        for(int j=1; j<m-1; j++)
        {
            if(grid[0][j] == 1)
            {
                bfs.Enqueue(Tuple.Create(0,j));
                visited[0,j]=1;
                count--;
            }
            if(n>1 && grid[n-1][j] == 1)
            {
                bfs.Enqueue(Tuple.Create(n-1,j));
                visited[n-1,j]=1;
                count--;
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
                if(newRow < n && newRow >= 0 && newCol < m && newCol >= 0 && visited[newRow, newCol] == 0 && grid[newRow][newCol] == 1)
                {
                    bfs.Enqueue(Tuple.Create(newRow,newCol));
                    visited[newRow,newCol] = 1;
                    count--;
                }
            }
        }
        return count;
    }
}