class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] visited = new int[grid1.length][grid1[0].length];
        int count = 0;
        for(int i=0; i<grid1.length; i++)
        {
            for(int j=0; j<grid1[0].length; j++)
            {
                if(visited[i][j] == 0 && grid2[i][j] == 1)
                {
                    if(isSubIsland(i,j,grid1,grid2,visited))
                    {
                        // System.out.println(i+" "+j);
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean isSubIsland(int row, int col, int[][] grid1, int[][] grid2, int[][] visited)
    {
        visited[row][col] = 1;
        int[] deltaRow = new int[] { -1,0,1,0 };
        int[] deltaCol = new int[] { 0,-1,0,1 };
        boolean ans = grid1[row][col] == 1;
        for(int i=0; i<4; i++)
        {
            int newRow = deltaRow[i] + row;
            int newCol = deltaCol[i] + col;
            if(newRow >= 0 && newRow < grid1.length && newCol >= 0 && newCol < grid1[0].length && grid2[newRow][newCol] == 1 && visited[newRow][newCol] == 0)
            {
                ans = isSubIsland(newRow, newCol, grid1, grid2, visited) && ans;
            }
        }
        return ans;
    }
}