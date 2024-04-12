class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // apply a dfs from boundary
        int numRows = heights.length;
        int numColumns = heights[0].length;
        int[][][] visited = new int[numRows][numColumns][2];
        ArrayList<List<Integer>> commonCells = new ArrayList<>();
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<numColumns; j++)
            {
                // pacific boundary
                if((j == 0) || (i == 0) && visited[i][j][1] == 0)
                {
                    dfs(i,j,visited,heights,1,commonCells);
                }
            }
        }
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<numColumns; j++)
            {
                if((j == numColumns-1) || i == numRows-1 && visited[i][j][0] == 0)
                {
                    dfs(i,j,visited,heights,0,commonCells);
                }
            }
        }
        for(int i=0; i<numRows; i++)
        {
            for(int j=0; j<numColumns; j++)
            {
                if(visited[i][j][0] == 1 && visited[i][j][1] == 1)
                {
                    var newCell = new ArrayList<Integer>();
                    newCell.add(i);
                    newCell.add(j);
                    commonCells.add(newCell);
                }
            }
        }
        return commonCells;
    }
    private void dfs(int row, int col, int[][][] visited, int[][] heights, int isPacificOcean, ArrayList<List<Integer>> commonCells)
    {
        visited[row][col][isPacificOcean] = 1;
        int[] deltaRow = new int[] { 1,0,-1,0 };
        int[] deltaColumn = new int[] { 0,1,0,-1 };
        for(int i=0; i<4; i++)
        {
            int newRow = deltaRow[i] + row;
            int newColumn = deltaColumn[i] + col;
            if(newRow >= 0 && newRow < heights.length && newColumn >= 0 && newColumn < heights[0].length
            && visited[newRow][newColumn][isPacificOcean] == 0 
            && heights[newRow][newColumn] >= heights[row][col])
            {
                dfs(newRow,newColumn,visited,heights,isPacificOcean,commonCells);
            }
        }
    }
}