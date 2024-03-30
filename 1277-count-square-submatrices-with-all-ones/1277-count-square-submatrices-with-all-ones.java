class Solution {
    int ans = 0;
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp)
        {
            Arrays.fill(row,-1);
        }
        getAns(0,0,matrix,matrix.length,matrix[0].length,dp);
        return ans;
    }
    private int getAns(int row, int col, int[][] matrix, int m, int n, int[][] dp)
    {
        if(row == m || col == n)
        {
            return 0;
        }
        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }
        int right = getAns(row,col+1,matrix,m,n,dp);
        int down = getAns(row+1,col,matrix,m,n,dp);
        int diagonal = getAns(row+1,col+1,matrix,m,n,dp);
        if(matrix[row][col] == 1)
        {
            ans += 1+Math.min(right, Math.min(down,diagonal));
            return dp[row][col] = 1 + Math.min(right, Math.min(down,diagonal));
        }
        return dp[row][col] = 0;
    }
}