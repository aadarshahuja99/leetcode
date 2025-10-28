class Solution {
    ArrayList<List<Integer>> commonCells = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // apply a dfs from boundary
        int numRows = heights.length;
        int numColumns = heights[0].length;
        int[][][] visited = new int[numRows][numColumns][2];
        for(int i=0; i<numRows; i++)
        {
            // pacific boundary left
            if(visited[i][0][1] == 0)
            {
                dfs(i,0,visited,heights,1);
            }
        }
        for(int i=0; i<numColumns; i++)
        {
            // pacific boundary top
            if(visited[0][i][1] == 0)
            {
                dfs(0,i,visited,heights,1);
            }
        }
        
        for(int i=0; i<numRows; i++)
        {
            // atlantic boundary right
            if(visited[i][numColumns-1][0] == 0)
            {
                dfs(i,numColumns-1,visited,heights,0);
            }
        }
        for(int i=0; i<numColumns; i++)
        {
            // atlantic boundary bottom
            if(visited[numRows-1][i][0] == 0)
            {
                dfs(numRows-1,i,visited,heights,0);
            }
        }
        return commonCells;
    }
    private void dfs(int row, int col, int[][][] visited, int[][] heights, int isPacificOcean)
    {
        visited[row][col][isPacificOcean] = 1;
        if(visited[row][col][0] == visited[row][col][1])
        {
            ArrayList<Integer> current = new ArrayList<>();
            current.add(row);
            current.add(col);
            commonCells.add(current);
        }
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
                dfs(newRow,newColumn,visited,heights,isPacificOcean);
            }
        }
    }
}