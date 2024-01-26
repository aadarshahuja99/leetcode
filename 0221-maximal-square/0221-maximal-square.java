class Solution {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int row = matrix.length-1; row>=0; row--)
        {
            for(int col = matrix[0].length-1; col>=0; col--)
            {
                int bottom = dp[row+1][col];
                int right = dp[row][col+1];
                int diagonal = dp[row+1][col+1];
                if(matrix[row][col] == '1')
                {
                    int ans = 1 + Math.min(Math.min(bottom, right), diagonal);
                    max = Math.max(max,ans);
                    dp[row][col] = ans;
                }
                else
                {
                    dp[row][col] = 0;
                }
            }
        }
        return max*max;
    }
    // high-level recursion
    private int getMaxSquareLength(int row, int col, char[][] matrix, int[][] dp)
    {
        if(row == matrix.length || col == matrix[0].length)
        {
            return 0;
        }
        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }
        int bottom = getMaxSquareLength(row+1,col,matrix,dp);
        int right = getMaxSquareLength(row,col+1,matrix,dp);
        int diagonal = getMaxSquareLength(row+1,col+1,matrix,dp);
        if(matrix[row][col] == '1')
        {
            int ans = 1 + Math.min(Math.min(bottom, right), diagonal);
            max = Math.max(max,ans);
            dp[row][col] = ans;
            return ans;
        }
        else
        {
            dp[row][col] = 0;
            return 0;
        }
    }
}