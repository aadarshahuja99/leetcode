public class Solution {
    public int[][] UpdateMatrix(int[][] mat) {
        // use bfs, initially, push all nodes with '0' in queue. Store ((i,j), dist) in queue
        if(mat.Length == 1 && mat[0].Length == 1)
        {
            return mat;
        }
        int[][] ans = new int[mat.Length][];
        int[][] visited = new int[mat.Length][];
        Queue<Tuple<int,int,int>> bfs = new();
        for(int i=0; i<mat.Length; i++)
        {
            ans[i] = new int[mat[i].Length];
            visited[i] = new int[mat[i].Length];
            for(int j=0; j<mat[i].Length; j++)
            {
                if(mat[i][j] == 0)
                {
                    bfs.Enqueue(Tuple.Create(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }
        int[] deltaRow = [1, 0, -1, 0];
        int[] deltaCol = [0, 1, 0, -1];
        while(bfs.Count > 0)
        {
            var top = bfs.Dequeue();
            int row = top.Item1;
            int col = top.Item2;
            int dist = top.Item3;
            for(int k=0; k<4; k++)
            {
                int newRow = row + deltaRow[k];
                int newCol = col + deltaCol[k];
                if(newRow < mat.Length && newRow >= 0 && newCol < mat[0].Length && newCol >= 0 && visited[newRow][newCol] == 0)
                {
                    visited[newRow][newCol] = 1;
                    ans[newRow][newCol] = dist+1;
                    bfs.Enqueue(Tuple.Create(newRow,newCol,dist+1));
                }
            }
        }
        return ans;
    }
}