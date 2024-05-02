class Solution {
    public int matrixMedian(int[][] grid) {
        int start = 0;
        int end = 1000000;
        int ans = -1;
        while(start <= end)
        {
            int guess = start + (end - start)/2;
            if(check(guess, grid))
            {
                ans = guess;
                end = guess-1;
            }
            else
            {
                start = guess+1;
            }
        }
        return ans;
    }
    private boolean check(int guess, int[][] grid)
    {
        int numberOfRows = grid.length;
        int numberOfColumns = grid[0].length;
        int count = 0;
        int required = (numberOfRows*numberOfColumns)/2 + 1;
        for(int i=0; i<numberOfRows; i++)
        {
            int start = 0;
            int end = numberOfColumns-1;
            int upper = -1;
            while(start <= end)
            {
                int mid = start + (end - start)/2;
                if(grid[i][mid] > guess)
                {
                    end = mid-1;
                    upper = mid;
                }
                else
                {
                    start = mid+1;
                }
            }
            if(upper == -1)
            {
                count += numberOfColumns;
            }
            else if(upper > 0)
            {
                count += upper;
            }
        }
        return count >= required;
    }
}