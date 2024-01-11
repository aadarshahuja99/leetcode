public class Solution {
    public int OrangesRotting(int[][] grid) {
        int[,] updated = new int[grid.Length,grid[0].Length];
        Queue<Tuple<int,int>> q = new();
        int count = Initialize(grid, ref q, ref updated);
        if(q.Count == 0 && count > 0)
        {
            return -1;
        }
        if(count == 0)
        {
            return 0;
        }
        int mins = 0;
        int[] deltaRow = [1, 0, -1, 0];
        int[] deltaCol = [0, 1, 0, -1];
        while(q.Count > 0 && count > 0)
        {
            int infected = 0;
            int size = q.Count;
            for(int it = 0; it < size; it++)
            {
                var top = q.Dequeue();
                int row = top.Item1;
                int col = top.Item2;
                for(int k=0; k<4; k++)
                {
                    int newRow = row + deltaRow[k];
                    int newCol = col + deltaCol[k];
                    if(newRow < grid.Length && newRow >= 0 && newCol < grid[0].Length && newCol >= 0 && updated[newRow, newCol] == 1)
                    {
                        updated[newRow,newCol] = 2;
                        count--;
                        q.Enqueue(Tuple.Create(newRow,newCol));
                        infected++;
                    }
                }
            }
            if(infected > 0)
            {
                mins++;
            }
        }
        if(count > 0)
        {
            return -1;
        }
        return mins;
    }
    private int Initialize(int[][] grid, ref Queue<Tuple<int,int>> q, ref int[,] updated)
    {
        int count = 0;
        for(int i=0; i<grid.Length; i++)
        {
            for(int j=0; j<grid[0].Length; j++)
            {
                if(grid[i][j] == 1)
                {
                    count++;
                }
                if(grid[i][j] == 2)
                {
                    q.Enqueue(Tuple.Create(i,j));
                }
                updated[i,j] = grid[i][j];
            }
        }
        return count;
    }
}