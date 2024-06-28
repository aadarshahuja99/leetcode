class Solution {
    public int minimumArea(int[][] grid) {
        int leftCol = Integer.MAX_VALUE;
        int rightCol = -1;
        int topRow = Integer.MAX_VALUE;
        int bottomRow = -1;
        int m = grid.length;
        int n = grid[0].length;
        boolean isPresent = false;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                {
                    if(leftCol == -1 || leftCol > j)
                    {
                        leftCol = j;
                    }
                    if(rightCol == -1 || rightCol < j)
                    {
                        rightCol = j;
                    }
                    if(topRow == -1 || topRow > i)
                    {
                        topRow = i;
                    }
                    if(bottomRow == -1 || bottomRow < i)
                    {
                        bottomRow = i;
                    }
                    isPresent = true;
                }
            }
        }
        // System.out.println(topRow+" "+bottomRow + " "+rightCol+ " "+leftCol+" "+isPresent);
        return isPresent ? (bottomRow - topRow + 1)*(rightCol - leftCol + 1) : 0;
    }
}